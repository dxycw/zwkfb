package 科特林.文本

/** 定义了用于标准排版的 Unicode 符号名称。*/
public object 排版 {
    /** 字符 &#x22; —— 引号 */
    public const val 引号: Char = Typography.quote
    /** 字符 &#x24; —— 美元符号 */
    public const val 美元: Char = Typography.dollar
    /** 字符 &#x26; —— 与号 */
    public const val 和号: Char = Typography.amp
    /** 字符 &#x3C; —— 小于号符号 */
    public const val 小于号: Char = Typography.less
    /** 字符 &#x3E; —— 大于号符号 */
    public const val 大于号: Char = Typography.greater
    /** 字符 &#x20; —— 非断行空格 */
    public const val 非断行空格: Char = Typography.nbsp
    /** 字符 &#xD7; —— 乘号 */
    public const val 乘号: Char = Typography.times
    /** 字符 &#xA2; —— 分号 */
    public const val 美分: Char = Typography.cent
    /** 字符 &#xA3; —— 英镑符号 */
    public const val 英镑: Char = Typography.pound
    /** 字符 &#xA7; —— 节符号 */
    public const val 节号: Char = Typography.section
    /** 字符 &#xA9; —— 版权符号 */
    public const val 版权: Char = Typography.copyright
    /** 字符 &#xAB; —— 左引号 */
    @SinceKotlin("1.6")
    public const val 左引号: Char = Typography.leftGuillemet
    /** 字符 &#xBB; —— 右引号 */
    @SinceKotlin("1.6")
    public const val 右引号: Char = Typography.rightGuillemet
    /** 字符 &#xAE; —— 注册商标符号 */
    public const val 已注册: Char = Typography.registered
    /** 字符 &#xB0; —— 度符号 */
    public const val 度: Char = Typography.degree
    /** 字符 &#xB1; —— 加减号符号 */
    public const val 加减号: Char = Typography.plusMinus
    /** 字符 &#xB6; —— 段落符号 */
    public const val 段落: Char = Typography.paragraph
    /** 字符 &#xB7; —— 中心点符号 */
    public const val 中心点: Char = Typography.middleDot
    /** 字符 &#xBD; —— 半角符号 */
    public const val 半角: Char = Typography.half
    /** 字符 &#x2013; —— 破折号符号 */
    public const val 破折号: Char = Typography.ndash
    /** 字符 &#x2014; —— 中破折号符号 */
    public const val 中破折号: Char = Typography.mdash
    /** 字符 &#x2018; —— 巕引号符号 */
    public const val 左单引号: Char = Typography.leftSingleQuote
    /** 字符 &#x2019; —— 叕引号符号 */
    public const val 右单引号: Char = Typography.rightSingleQuote
    /** 字符 &#x201A; —— 左单引号符号 */
    public const val 低单引号: Char = Typography.lowSingleQuote
    /** 字符 &#x201C; —— 左双引号符号 */
    public const val 左双引号: Char = Typography.leftDoubleQuote
    /** 字符 &#x201D; —— 右双引号符号 */
    public const val 右双引号: Char = Typography.rightDoubleQuote
    /** 字符 &#x201E; —— 左双引号符号 */
    public const val 低双引号: Char = Typography.lowDoubleQuote
    /** 字符 &#x2020; —— 口号符号 */
    public const val 剑号: Char = Typography.dagger
    /** 字符 &#x2021; —— 双口号符号 */
    public const val 双剑号: Char = Typography.doubleDagger
    /** 字符 &#x2022; —— 点符号 */
    public const val 圆点: Char = Typography.bullet
    /** 字符 &#x2026; —— 省略号符号 */
    public const val 省略号: Char = Typography.ellipsis
    /** 字符 &#x2032; —— 分号符号 */
    public const val 单引号: Char = Typography.prime
    /** 字符 &#x2033; —— 双分号符号 */
    public const val 双引号: Char = Typography.doublePrime
    /** 字符 &#x20AC; —— 欧元符号 */
    public const val 欧元: Char = Typography.euro
    /** 字符 &#x2122; —— 商标符号 */
    public const val 商标: Char = Typography.tm
    /** 字符 &#x2248; —— 大约等于符号 */
    public const val 约等于: Char = Typography.almostEqual
    /** 字符 &#x2260; —— 不等于符号 */
    public const val 不等于: Char = Typography.notEqual
    /** 字符 &#x2264; —— 小于等于符号 */
    public const val 小于等于: Char = Typography.lessOrEqual
    /** 字符 &#x2265; —— 大于等于符号 */
    public const val 大于等于: Char = Typography.greaterOrEqual

    /** 字符 &#xAB; —— 左引号 */
    @Deprecated("This constant has a typo in the name. Use leftGuillemet instead.", ReplaceWith("Typography.leftGuillemet"))
    public const val 左书名号: Char = Typography.leftGuillemete

    /** 字符 &#xBB; —— 右引号 */
    @Deprecated("This constant has a typo in the name. Use rightGuillemet instead.", ReplaceWith("Typography.rightGuillemet"))
    public const val 右书名号: Char = Typography.rightGuillemete

}