package 自定义.组合.材质3.网页

import android.os.Build
import android.webkit.WebSettings


open class 浏览器配置集 : WebSettings() {

    enum class 安卓{
        夸克UA,
        EdgUA,
        百度UA
    }

    object Android {
        var 夸克UA: String =
            "Mozilla/5.0 (Linux; U; Android ${Build.VERSION.SDK_INT}; zh-CN; ${Build.MODEL} Build/AP3A.240905.015.A1) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/123.0.6312.80 Quark/7.5.1.691 Mobile Safari/537.36"
        var EdgUA: String =
            "Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Mobile Safari/537.36 EdgA/131.0.0.0"
        var 百度UA: String =
            "Mozilla/5.0 (Linux; Android ${Build.VERSION.SDK_INT}; ${Build.MODEL} Build/AP3A.240905.015.A1; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/97.0.4692.98 Mobile Safari/537.36 T7/13.75 SP-engine/2.81.0 matrixstyle/0 lite baiduboxapp/6.43.0.11 (Baidu; P1 15) NABar/1.0"
    }

    class IOS

    class MacOS

    object Windows {
        var 夸克UA: String =
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36 QuarkPC/1.9.5.161"
        var EdgUA: String =
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 Safari/537.36 Edg/132.0.0.0"
    }


    override fun setSupportZoom(support: Boolean) {

    }

    override fun supportZoom(): Boolean {
        return false
    }

    override fun setMediaPlaybackRequiresUserGesture(require: Boolean) {

    }

    override fun getMediaPlaybackRequiresUserGesture(): Boolean {
        return false
    }

    override fun setBuiltInZoomControls(enabled: Boolean) {
    }

    override fun getBuiltInZoomControls(): Boolean {
        return false
    }

    override fun setDisplayZoomControls(enabled: Boolean) {
    }

    override fun getDisplayZoomControls(): Boolean {
        return false
    }

    override fun setAllowFileAccess(allow: Boolean) {
    }

    override fun getAllowFileAccess(): Boolean {
        return false
    }

    override fun setAllowContentAccess(allow: Boolean) {
    }

    override fun getAllowContentAccess(): Boolean {
        return false
    }

    override fun setLoadWithOverviewMode(overview: Boolean) {
    }

    override fun getLoadWithOverviewMode(): Boolean {
        return false
    }

    @Deprecated("Deprecated in Java")
    override fun setEnableSmoothTransition(enable: Boolean) {
    }

    @Deprecated("Deprecated in Java")
    override fun enableSmoothTransition(): Boolean {
        return false
    }

    @Deprecated("Deprecated in Java")
    override fun setSaveFormData(save: Boolean) {
    }

    @Deprecated("Deprecated in Java")
    override fun getSaveFormData(): Boolean {
        return false
    }

    @Deprecated("Deprecated in Java")
    override fun setSavePassword(save: Boolean) {
    }

    @Deprecated("Deprecated in Java")
    override fun getSavePassword(): Boolean {
        return false
    }

    override fun setTextZoom(textZoom: Int) {
    }

    override fun getTextZoom(): Int {
        return 0
    }

    @Deprecated("Deprecated in Java")
    override fun setDefaultZoom(zoom: ZoomDensity?) {
    }

    @Deprecated("Deprecated in Java")
    override fun getDefaultZoom(): ZoomDensity? {
        return null
    }

    @Deprecated("Deprecated in Java")
    override fun setLightTouchEnabled(enabled: Boolean) {
    }

    @Deprecated("Deprecated in Java")
    override fun getLightTouchEnabled(): Boolean {
        return false
    }

    override fun setUseWideViewPort(use: Boolean) {
    }

    override fun getUseWideViewPort(): Boolean {
        return false
    }

    override fun setSupportMultipleWindows(support: Boolean) {
    }

    override fun supportMultipleWindows(): Boolean {
        return false
    }

    override fun setLayoutAlgorithm(l: LayoutAlgorithm?) {
    }


    override fun getLayoutAlgorithm(): LayoutAlgorithm? {
        return null
    }

    override fun setStandardFontFamily(font: String?) {
    }

    override fun getStandardFontFamily(): String {
        return ""
    }

    override fun setFixedFontFamily(font: String?) {
    }

    override fun getFixedFontFamily(): String {
        return ""
    }

    override fun setSansSerifFontFamily(font: String?) {
    }

    override fun getSansSerifFontFamily(): String {
        return ""
    }

    override fun setSerifFontFamily(font: String?) {
    }

    override fun getSerifFontFamily(): String {
        return ""
    }

    override fun setCursiveFontFamily(font: String?) {
    }

    override fun getCursiveFontFamily(): String {
        return ""
    }

    override fun setFantasyFontFamily(font: String?) {
    }

    override fun getFantasyFontFamily(): String {
        return ""
    }

    override fun setMinimumFontSize(size: Int) {
    }

    override fun getMinimumFontSize(): Int {
        return 0
    }

    override fun setMinimumLogicalFontSize(size: Int) {
    }

    override fun getMinimumLogicalFontSize(): Int {
        return 0
    }

    override fun setDefaultFontSize(size: Int) {
    }

    override fun getDefaultFontSize(): Int {
        return 0
    }

    override fun setDefaultFixedFontSize(size: Int) {
    }

    override fun getDefaultFixedFontSize(): Int {
        return 0
    }

    override fun setLoadsImagesAutomatically(flag: Boolean) {
    }

    override fun getLoadsImagesAutomatically(): Boolean {
        return false
    }

    override fun setBlockNetworkImage(flag: Boolean) {
    }

    override fun getBlockNetworkImage(): Boolean {
        return false
    }

    override fun setBlockNetworkLoads(flag: Boolean) {
    }

    override fun getBlockNetworkLoads(): Boolean {
        return false
    }

    override fun setJavaScriptEnabled(flag: Boolean) {
    }

    @Deprecated("Deprecated in Java")
    override fun setAllowUniversalAccessFromFileURLs(flag: Boolean) {
    }

    @Deprecated("Deprecated in Java")
    override fun setAllowFileAccessFromFileURLs(flag: Boolean) {
    }

    @Deprecated("Deprecated in Java")
    override fun setPluginState(state: PluginState?) {
    }

    @Deprecated("Deprecated in Java")
    override fun setDatabasePath(databasePath: String?) {
    }

    @Deprecated("Deprecated in Java")
    override fun setGeolocationDatabasePath(databasePath: String?) {
    }

    @Deprecated("Deprecated in Java")
    override fun setDatabaseEnabled(flag: Boolean) {
    }

    override fun setDomStorageEnabled(flag: Boolean) {
    }

    override fun getDomStorageEnabled(): Boolean {
        return false
    }

    @Deprecated("Deprecated in Java")
    override fun getDatabasePath(): String {
        return ""
    }

    @Deprecated("Deprecated in Java")
    override fun getDatabaseEnabled(): Boolean {
        return false
    }

    override fun setGeolocationEnabled(flag: Boolean) {
    }

    override fun getJavaScriptEnabled(): Boolean {
        return false
    }

    override fun getAllowUniversalAccessFromFileURLs(): Boolean {
        return false
    }

    override fun getAllowFileAccessFromFileURLs(): Boolean {
        return false
    }

    @Deprecated("Deprecated in Java")
    override fun getPluginState(): PluginState? {
        return null
    }

    override fun setJavaScriptCanOpenWindowsAutomatically(flag: Boolean) {
    }

    override fun getJavaScriptCanOpenWindowsAutomatically(): Boolean {
        return false
    }

    override fun setDefaultTextEncodingName(encoding: String?) {
    }

    override fun getDefaultTextEncodingName(): String {
        return ""
    }

    override fun setUserAgentString(ua: String?) {
    }

    override fun getUserAgentString(): String {
        return ""
    }

    override fun setNeedInitialFocus(flag: Boolean) {
    }

    @Deprecated("Deprecated in Java")
    override fun setRenderPriority(priority: RenderPriority?) {
    }

    override fun setCacheMode(mode: Int) {
    }

    @Suppress("DEPRECATION")
    override fun getCacheMode(): Int {
        return LOAD_NORMAL
    }

    override fun setMixedContentMode(mode: Int) {
    }

    override fun getMixedContentMode(): Int {
        return 0
    }

    override fun setOffscreenPreRaster(enabled: Boolean) {
    }

    override fun getOffscreenPreRaster(): Boolean {
        return false
    }

    override fun setSafeBrowsingEnabled(enabled: Boolean) {
    }

    override fun getSafeBrowsingEnabled(): Boolean {
        return false
    }

    override fun setDisabledActionModeMenuItems(menuItems: Int) {
    }

    override fun getDisabledActionModeMenuItems(): Int {
        return 0
    }
}


//===================================================================================================

//fun WebSettings.安卓置ua(ua: 浏览器配置.安卓 = 浏览器配置.安卓.夸克UA){
//    this.userAgentString = when(ua){
//        浏览器配置.安卓.夸克UA -> "Mozilla/5.0 (Linux; U; Android " + 构建.版本.系统版本号() + "; zh-CN; " + 构建.型号() + " Build/AP3A.240905.015.A1) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/123.0.6312.80 Quark/7.5.1.691 Mobile Safari/537.36"
//        浏览器配置.安卓.EdgUA -> "Mozilla/5.0 (Linux; Android " + 构建.版本.系统版本号() + "; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Mobile Safari/537.36 EdgA/131.0.0.0"
//        浏览器配置.安卓.百度UA -> "Mozilla/5.0 (Linux; Android " + 构建.版本.系统版本号() + "; " + 构建.型号() + " Build/AP3A.240905.015.A1; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/97.0.4692.98 Mobile Safari/537.36 T7/13.75 SP-engine/2.81.0 matrixstyle/0 lite baiduboxapp/6.43.0.11 (Baidu; P1 15) NABar/1.0"
//    }
//}

//==========================================================================================

var WebSettings.JavaScript启用: Boolean
    get() = this.javaScriptEnabled
    set(值) {this.javaScriptEnabled = 值 }
fun WebSettings.取JavaScript启用(): Boolean = this.javaScriptEnabled
fun WebSettings.置JavaScript启用(启动: Boolean){ this.javaScriptEnabled = 启动 }

//==========================================================================================

var WebSettings.用户代理字符串: String
    get() = this.userAgentString
    set(值) {this.userAgentString = 值 }

fun WebSettings.取用户代理字符串(): String = this.userAgentString
fun WebSettings.置用户代理字符串(值: String){ this.userAgentString = 值 }


