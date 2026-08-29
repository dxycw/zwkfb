package 自定义.系统.组合.相机


import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.Camera
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FlashOff
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext


@SuppressLint("ComposableNaming","ModifierParameter")
@Composable
fun 扫码相册手电筒布局(
    修饰符: Modifier = Modifier,
    返回单击回调: () -> Unit = {},
    当前缩放比例: Float = 0f,
    相机回调: (Camera) -> Unit = {},
    解析结果回调: (String) -> Unit
) {
    var 闪光灯状态 by remember { mutableStateOf(false) }
    var 相机状态 by remember { mutableStateOf<Camera?>(null) }
    var 相册启动器: ManagedActivityResultLauncher<String, Uri?>? = null

    扫码布局(
        修饰符 = 修饰符,
        返回单击回调 = 返回单击回调,
        当前缩放比例 = 当前缩放比例,
        相机回调 = { 相机 ->
            相机回调(相机)
            相机状态 = 相机
        },
        相册启动器 = {
            相册启动器 = it
        },
        相册单击回调 = {
            相册启动器!!.launch("image/*")
        },
        闪光灯状态 = 闪光灯状态,
        闪光灯单击回调 = {
            val 新状态 = !闪光灯状态
            相机状态?.cameraControl?.enableTorch(新状态)
            闪光灯状态 = 新状态
        },
        解析结果回调 = 解析结果回调
    )
}



@SuppressLint("ComposableNaming","ModifierParameter")
@Composable
fun 扫码相册手电筒缩放布局(
    修饰符: Modifier = Modifier,
    当前缩放比例: Float = 0f,
    返回单击回调: () -> Unit = {},
    解析结果回调: (String) -> Unit
) {
    var 相机状态 by remember { mutableStateOf<Camera?>(null) }
    var 当前缩放比例状态 by remember { mutableFloatStateOf(当前缩放比例) }

    扫码相册手电筒布局(
        修饰符 = 修饰符
            .相机手指缩放(相机状态){
                当前缩放比例状态 = it
            },
        返回单击回调 = 返回单击回调,
        当前缩放比例 = 当前缩放比例状态,
        相机回调 = { 相机 ->
            相机状态 = 相机
        },
        解析结果回调 = 解析结果回调
    )
}


//================================================================

@SuppressLint("ComposableNaming","ModifierParameter")
@Composable
internal fun 扫码布局(
    修饰符: Modifier = Modifier,
    返回单击回调: () -> Unit = {},
    当前缩放比例: Float = 0f,
    相机回调: (Camera) -> Unit = {},
    相册启动器: (ManagedActivityResultLauncher<String, Uri?>) -> Unit = {},
    相册单击回调: () -> Unit = {},
    闪光灯状态: Boolean = false,
    闪光灯单击回调: () -> Unit = {},
    解析结果回调: (String) -> Unit
) {
    申请相机权限()

    扫码界面布局(
        修饰符 = 修饰符,
        返回单击回调 = 返回单击回调,
        当前缩放比例布局 = {
            // 可选：在右上角显示当前缩放倍数
            if (当前缩放比例 > 0f){
                Text(
                    text = 小数点格式化(1, 当前缩放比例),
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 100.dp)
                )
            }
        },
        相机布局 = {
            // 相机预览
            相机扫码(
                修饰符 = Modifier,
                相机回调 = 相机回调,
                相册启动器 = 相册启动器,
                解析结果回调 = 解析结果回调,
            )
        },
        扫描线布局 = {
            // 扫描框UI
            扫码线(显示扫描线 = true, 显示斑点 = true)
        },
        闪光灯状态 = 闪光灯状态,
        闪光灯单击回调 = 闪光灯单击回调,
        相册单击回调 = 相册单击回调,
    )
}


@SuppressLint("ComposableNaming","ModifierParameter")
@Composable
internal fun 扫码界面布局(
    修饰符: Modifier = Modifier,
    返回单击回调: () -> Unit = {},
    当前缩放比例布局: @Composable (BoxScope.() -> Unit) = { },
    相机布局: @Composable (BoxScope.() -> Unit) = { },
    扫描线布局: @Composable (BoxScope.() -> Unit) = { },
    闪光灯状态: Boolean = false,
    闪光灯单击回调: () -> Unit = {},
    相册单击回调: () -> Unit = {},
){
    Box(
        modifier = 修饰符.fillMaxSize(),
        contentAlignment = Alignment.Center,
        content = {
            // 相机预览
            相机布局()
            // 扫描框UI
            扫描线布局()
            // 顶部标题栏
            TopAppBar(
                title = {
                    Text(
                        text = "扫一扫",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                },
                modifier = Modifier.align(Alignment.TopCenter),
                navigationIcon = {
                    IconButton(onClick = 返回单击回调) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "返回",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                )
            )
            // 可选：在右上角显示当前缩放倍数
            当前缩放比例布局()
            // 底部控制栏
            扫码底部导航栏(
                修饰符 = Modifier.align(Alignment.BottomCenter),
                相册单击回调 = 相册单击回调,
                闪光灯状态 = 闪光灯状态,
                闪光灯单击回调 = 闪光灯单击回调,
            )
        }
    )
}


//================================================================


internal fun 小数点格式化(
    小数点个数: Int,
    数字: Float
): String = "%.${小数点个数}fx".format(数字)



/**
 * 捏合缩放手势
 */
internal fun Modifier.相机手指缩放(
    相机: Camera?,
    当前缩放比例: (Float) -> Unit = { _ ->  },
) = composed {
    var 当前缩放比例状态 by remember { mutableFloatStateOf(1f) }

    // 相机切换后，同步新摄像头的初始 zoom
    LaunchedEffect(相机) {
        相机?.cameraInfo?.zoomState?.value?.let {
            当前缩放比例状态 = it.zoomRatio
        }
    }

    this.pointerInput(相机) {
        detectTransformGestures { _, _, zoom, _ ->
            val control = 相机 ?: return@detectTransformGestures
            val zoomState = control.cameraInfo.zoomState.value ?: return@detectTransformGestures

            当前缩放比例状态 *= zoom
            当前缩放比例状态 = 当前缩放比例状态.coerceIn(
                zoomState.minZoomRatio,
                zoomState.maxZoomRatio
            )
            control.cameraControl.setZoomRatio(当前缩放比例状态)
            当前缩放比例(当前缩放比例状态)
        }
    }
}

//=============================================================================

@SuppressLint("ComposableNaming","ModifierParameter")
@Composable
internal fun 扫码底部导航栏(
    修饰符: Modifier = Modifier,
    相册单击回调: () -> Unit = {},
    闪光灯状态: Boolean = false,
    闪光灯单击回调: () -> Unit = {},
){
    Row (
        modifier = 修饰符.fillMaxWidth().padding(30.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        // 相册控制
        扫码图标按钮(
            图像矢量 = Icons.Default.Image,
            内容描述 = "相册",
            图标色调 = Color.White,
            单击回调 = 相册单击回调
        )

        Spacer(modifier = Modifier.width(100.dp))

        // 闪光灯控制
        扫码图标按钮(
            图像矢量 = if (闪光灯状态) Icons.Default.FlashOn else Icons.Default.FlashOff,
            内容描述 = "闪光灯",
            图标色调 = Color.White,
            单击回调 = 闪光灯单击回调
        )

        // Icons.Default.Cameraswitch  // 摄像头切换
    }
}


@SuppressLint("ComposableNaming")
@Composable
internal fun 扫码图标按钮(
    图像矢量: ImageVector,
    内容描述: String? = null,
    图标色调: Color = LocalContentColor.current,
    单击回调: () -> Unit
){
    Box(
        modifier = Modifier.size(56.dp)
            .background(color = Color(0x55FFFFFF), shape = MaterialTheme.shapes.medium)
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable{ 单击回调() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = 图像矢量,
            contentDescription = 内容描述,
            tint = 图标色调,
            modifier = Modifier.size(32.dp)
        )
    }
}

//=============================================================================

@SuppressLint("ComposableNaming", "ModifierParameter")
@Composable
internal fun 申请相机权限() {
    val 上下文 = LocalContext.current
    // 权限处理
    var 有权限 by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                上下文,
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
        )
    }
    val 权限启动器 = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted -> 有权限 = granted }

    LaunchedEffect(Unit) {
        if (!有权限) 权限启动器.launch(Manifest.permission.CAMERA)
    }

    if (!有权限) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) { Text("需要相机权限") }
        return
    }
}
