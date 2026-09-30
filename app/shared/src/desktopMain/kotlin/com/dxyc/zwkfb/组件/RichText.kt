package com.dxyc.zwkfb.组件


//fun RichText(text: String) {
//    val textFieldState = rememberTextFieldState()
//    val richTextState = rememberRichTextState()
//
//    // 方式二：使用 Markdown 设置初始内容
//    richTextState.setMarkdown(textFieldState.text.toString())
//    val myUriHandler by remember {
//        mutableStateOf(object : UriHandler {
//            override fun openUri(uri: String) {
//                // Handle the clicked link however you want
//            }
//        })
//    }
//
//    Row {
//
//        TextField(
//            state = textFieldState,
//            modifier = Modifier.fillMaxHeight().weight(1f)
//        )
//
//        CompositionLocalProvider(LocalUriHandler provides myUriHandler) {
//            RichText(
//                state = richTextState,
//                modifier = Modifier.fillMaxHeight().weight(1f)
//            )
//        }
//
//    }
//}


