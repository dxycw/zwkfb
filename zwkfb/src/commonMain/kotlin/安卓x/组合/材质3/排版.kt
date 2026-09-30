package 安卓x.组合.材质3

import androidx.compose.material3.Typography
import 安卓x.组合.材质3.令牌集.TypographyTokens
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily

/**
 * Material Design 字体比例包含一系列对比鲜明的样式，以满足您的产品及其内容的需求。
 *
 * 使用排版使文字清晰易读且美观。Material 的默认字体比例包含对比鲜明且灵活的样式，以支持广泛的使用场景。
 *
 * 字体比例是由字体系统支持的十三种样式的组合。它包含可复用的文本类别，每个类别都有特定的应用场景和含义。
 *
 * 基线样式的强调版本为基线样式增添了动感和个性。它可以用于进一步美化选定的文本片段。强调状态具有实用用途，
 * 例如创建更清晰的内容划分，以及将用户的注意力吸引到相关材料上。
 *
 * To learn more about typography, see [Material Design typography](https://m3.material.io/styles/typography/overview).
 *
 * @param 显示大型 displayLarge 是最大的展示文本。
 * @param 显示中等 displayMedium 是第二大的展示文本。
 * @param 显示小型 displaySmall 是最小的展示文本。
 * @param 大标题大型 headlineLarge 是最大的标题，用于简短、重要的文本或数字。对于标题，您可以选择富有表现力的字体，
 * 例如展示体、手写体或手写风格。这些非常规的字体设计具有细节和复杂性，有助于吸引视线。
 * @param 大标题中等 headlineMedium 是第二大的标题，用于简短、重要的文本或数字。对于标题，您可以选择富有表现力的字体，
 * 例如展示体、手写体或手写风格。这些非常规的字体设计具有细节和复杂性，有助于吸引视线。
 * @param 大标题小型 headlineSmall 是最小的标题，用于简短、重要的文本或数字。对于标题，您可以选择富有表现力的字体，
 * 例如展示体、手写体或手写风格。这些非常规的字体设计具有细节和复杂性，有助于吸引视线。
 * @param 标题大型 titleLarge 是最大的标题文本，通常用于长度较短的中等强调文本。衬线体或无衬线体都适合用于副标题。
 * @param 标题中等 titleMedium 是第二大的标题文本，通常用于长度较短的中等强调文本。衬线体或无衬线体都适合用于副标题。
 * @param 标题小型 titleSmall 是最小的标题文本，通常用于长度较短的中等强调文本。衬线体或无衬线体都适合用于副标题。
 * @param 正文大型 bodyLarge 是最大的正文文本，通常用于长篇写作，因为它非常适合较小的字号。对于较长的文本段落，
 * 建议使用衬线体或无衬线体。
 * @param 正文中等 bodyMedium 是第二大的正文文本，通常用于长篇写作，因为它非常适合较小的字号。对于较长的文本段落，
 * 建议使用衬线体或无衬线体。
 * @param 正文小型 bodySmall 是最小的正文文本，通常用于长篇写作，因为它非常适合较小的字号。对于较长的文本段落，
 * 建议使用衬线体或无衬线体。
 * @param 标签大型 labelLarge 文本是用于不同类型按钮（如文本按钮、轮廓按钮和填充按钮）以及标签页、对话框和卡片中的行动号召。
 * 按钮文本通常使用无衬线体，并采用全大写形式。
 * @param 标签中等 labelMedium 是最小的字号之一。它仅少量用于为图片添加注释或作为标题的引子。
 * @param 标签小型 labelSmall 是最小的字号之一。它仅少量用于为图片添加注释或作为标题的引子。
 * @param 显示大型强调 [显示大型] 的强调版本。
 * @param 显示中等强调 [显示中等] 的强调版本。
 * @param 显示小型强调 [显示小型] 的强调版本。
 * @param 大标题大型强调 [大标题大型] 的强调版本。
 * @param 大标题中等强调 [大标题中等] 的强调版本。
 * @param 大标题小型强调 [大标题小型] 的强调版本。
 * @param 标题大型强调 [标题大型] 的强调版本。
 * @param 标题中等强调 [标题中等] 的强调版本。
 * @param 标题小型强调 [标题小型] 的强调版本。
 * @param 正文大型强调 [正文大型] 的强调版本。
 * @param 正文中等强调 [正文中等] 的强调版本。
 * @param 正文小型强调 [正文小型] 的强调版本。
 * @param 标签大型强调 [标签大型] 的强调版本。
 * @param 标签中等强调 [标签中等] 的强调版本。
 * @param 标签小型强调 [标签小型] 的强调版本。
 */
fun 排版(
    显示大型: TextStyle = typographyTokens.DisplayLarge,
    显示中等: TextStyle = typographyTokens.DisplayMedium,
    显示小型: TextStyle = typographyTokens.DisplaySmall,
    大标题大型: TextStyle = typographyTokens.HeadlineLarge,
    大标题中等: TextStyle = typographyTokens.HeadlineMedium,
    大标题小型: TextStyle = typographyTokens.HeadlineSmall,
    标题大型: TextStyle = typographyTokens.TitleLarge,
    标题中等: TextStyle = typographyTokens.TitleMedium,
    标题小型: TextStyle = typographyTokens.TitleSmall,
    正文大型: TextStyle = typographyTokens.BodyLarge,
    正文中等: TextStyle = typographyTokens.BodyMedium,
    正文小型: TextStyle = typographyTokens.BodySmall,
    标签大型: TextStyle = typographyTokens.LabelLarge,
    标签中等: TextStyle = typographyTokens.LabelMedium,
    标签小型: TextStyle = typographyTokens.LabelSmall,
    显示大型强调: TextStyle = typographyTokens.DisplayLargeEmphasized,
    显示中等强调: TextStyle = typographyTokens.DisplayMediumEmphasized,
    显示小型强调: TextStyle = typographyTokens.DisplaySmallEmphasized,
    大标题大型强调: TextStyle = typographyTokens.HeadlineLargeEmphasized,
    大标题中等强调: TextStyle = typographyTokens.HeadlineMediumEmphasized,
    大标题小型强调: TextStyle = typographyTokens.HeadlineSmallEmphasized,
    标题大型强调: TextStyle = typographyTokens.TitleLargeEmphasized,
    标题中等强调: TextStyle = typographyTokens.TitleMediumEmphasized,
    标题小型强调: TextStyle = typographyTokens.TitleSmallEmphasized,
    正文大型强调: TextStyle = typographyTokens.BodyLargeEmphasized,
    正文中等强调: TextStyle = typographyTokens.BodyMediumEmphasized,
    正文小型强调: TextStyle = typographyTokens.BodySmallEmphasized,
    标签大型强调: TextStyle = typographyTokens.LabelLargeEmphasized,
    标签中等强调: TextStyle = typographyTokens.LabelMediumEmphasized,
    标签小型强调: TextStyle = typographyTokens.LabelSmallEmphasized,
) =
    Typography(
        displayLarge = 显示大型,
        displayMedium = 显示中等,
        displaySmall = 显示小型,
        headlineLarge = 大标题大型,
        headlineMedium = 大标题中等,
        headlineSmall = 大标题小型,
        titleLarge = 标题大型,
        titleMedium = 标题中等,
        titleSmall = 标题小型,
        bodyLarge = 正文大型,
        bodyMedium = 正文中等,
        bodySmall = 正文小型,
        labelLarge = 标签大型,
        labelMedium = 标签中等,
        labelSmall = 标签小型,
        displayLargeEmphasized = 显示大型强调,
        displayMediumEmphasized = 显示中等强调,
        displaySmallEmphasized = 显示小型强调,
        headlineLargeEmphasized = 大标题大型强调,
        headlineMediumEmphasized = 大标题中等强调,
        headlineSmallEmphasized = 大标题小型强调,
        titleLargeEmphasized = 标题大型强调,
        titleMediumEmphasized = 标题中等强调,
        titleSmallEmphasized = 标题小型强调,
        bodyLargeEmphasized = 正文大型强调,
        bodyMediumEmphasized = 正文中等强调,
        bodySmallEmphasized = 正文小型强调,
        labelLargeEmphasized = 标签大型强调,
        labelMediumEmphasized = 标签中等强调,
        labelSmallEmphasized = 标签小型强调,
    )



/**
 * Material Design 字体比例包含一系列对比鲜明的样式，以满足您的产品及其内容的需求。
 *
 * 使用排版使文字清晰易读且美观。Material 的默认字体比例包含对比鲜明且灵活的样式，以支持广泛的使用场景。
 *
 * 字体比例是由字体系统支持的十三种样式的组合。它包含可复用的文本类别，每个类别都有特定的应用场景和含义。
 *
 * 要了解更多关于排版的信息，请参阅 [Material Design typography](https://m3.material.io/styles/typography/overview).
 *
 * @param 字体族 排版要使用的 [FontFamily]。
 * @param 显示大型 displayLarge 是最大的展示文本。
 * @param 显示中等 displayMedium 是第二大的展示文本。
 * @param 显示小型 displaySmall 是最小的展示文本。
 * @param 大标题大型 headlineLarge 是最大的标题，用于简短、重要的文本或数字。对于标题，您可以选择富有表现力的字体，
 * 例如展示体、手写体或手写风格。这些非常规的字体设计具有细节和复杂性，有助于吸引视线。
 * @param 大标题中等 headlineMedium 是第二大的标题，用于简短、重要的文本或数字。对于标题，您可以选择富有表现力的字体，
 * 例如展示体、手写体或手写风格。这些非常规的字体设计具有细节和复杂性，有助于吸引视线。
 * @param 大标题小型 headlineSmall 是最小的标题，用于简短、重要的文本或数字。对于标题，您可以选择富有表现力的字体，
 * 例如展示体、手写体或手写风格。这些非常规的字体设计具有细节和复杂性，有助于吸引视线。
 * @param 标题大型 titleLarge 是最大的标题文本，通常用于长度较短的中等强调文本。衬线体或无衬线体都适合用于副标题。
 * @param 标题中等 titleMedium 是第二大的标题文本，通常用于长度较短的中等强调文本。衬线体或无衬线体都适合用于副标题。
 * @param 标题小型 titleSmall 是最小的标题文本，通常用于长度较短的中等强调文本。衬线体或无衬线体都适合用于副标题。
 * @param 正文大型 bodyLarge 是最大的正文文本，通常用于长篇写作，因为它非常适合较小的字号。对于较长的文本段落，建议使用衬线体或无衬线体。
 * @param 正文中等 bodyMedium 是第二大的正文文本，通常用于长篇写作，因为它非常适合较小的字号。对于较长的文本段落，建议使用衬线体或无衬线体。
 * @param 正文小型 bodySmall 是最小的正文文本，通常用于长篇写作，因为它非常适合较小的字号。对于较长的文本段落，建议使用衬线体或无衬线体。
 * @param 标签大型 labelLarge 文本是用于不同类型按钮（如文本按钮、轮廓按钮和填充按钮）以及标签页、对话框和卡片中的行动号召。按钮文本通常使用无衬线体，并采用全大写形式。
 * @param 标签中等 labelMedium 是最小的字号之一。它仅少量用于为图片添加注释或作为标题的引子。
 * @param 标签小型 labelSmall 是最小的字号之一。它仅少量用于为图片添加注释或作为标题的引子。
 * @param 显示大型强调 [显示大型] 的强调版本。
 * @param 显示中等强调 [显示中等] 的强调版本。
 * @param 显示小型强调 [显示小型] 的强调版本。
 * @param 大标题大型强调 [大标题大型] 的强调版本。
 * @param 大标题中等强调 [大标题中等] 的强调版本。
 * @param 大标题小型强调 [大标题小型] 的强调版本。
 * @param 标题大型强调 [标题大型] 的强调版本。
 * @param 标题中等强调 [标题中等] 的强调版本。
 * @param 标题小型强调 [标题小型] 的强调版本。
 * @param 正文大型强调 [正文大型] 的强调版本。
 * @param 正文中等强调 [正文中等] 的强调版本。
 * @param 正文小型强调 [正文小型] 的强调版本。
 * @param 标签大型强调 [标签大型] 的强调版本。
 * @param 标签中等强调 [标签中等] 的强调版本。
 * @param 标签小型强调 [标签小型] 的强调版本。
 */
fun 排版(
    字体族: FontFamily,
    显示大型: TextStyle? = null,
    显示中等: TextStyle? = null,
    显示小型: TextStyle? = null,
    大标题大型: TextStyle? = null,
    大标题中等: TextStyle? = null,
    大标题小型: TextStyle? = null,
    标题大型: TextStyle? = null,
    标题中等: TextStyle? = null,
    标题小型: TextStyle? = null,
    正文大型: TextStyle? = null,
    正文中等: TextStyle? = null,
    正文小型: TextStyle? = null,
    标签大型: TextStyle? = null,
    标签中等: TextStyle? = null,
    标签小型: TextStyle? = null,
    显示大型强调: TextStyle? = null,
    显示中等强调: TextStyle? = null,
    显示小型强调: TextStyle? = null,
    大标题大型强调: TextStyle? = null,
    大标题中等强调: TextStyle? = null,
    大标题小型强调: TextStyle? = null,
    标题大型强调: TextStyle? = null,
    标题中等强调: TextStyle? = null,
    标题小型强调: TextStyle? = null,
    正文大型强调: TextStyle? = null,
    正文中等强调: TextStyle? = null,
    正文小型强调: TextStyle? = null,
    标签大型强调: TextStyle? = null,
    标签中等强调: TextStyle? = null,
    标签小型强调: TextStyle? = null,
) =
    Typography(
        fontFamily = 字体族,
        displayLarge = 显示大型,
        displayMedium = 显示中等,
        displaySmall = 显示小型,
        headlineLarge = 大标题大型,
        headlineMedium = 大标题中等,
        headlineSmall = 大标题小型,
        titleLarge = 标题大型,
        titleMedium = 标题中等,
        titleSmall = 标题小型,
        bodyLarge = 正文大型,
        bodyMedium = 正文中等,
        bodySmall = 正文小型,
        labelLarge = 标签大型,
        labelMedium = 标签中等,
        labelSmall = 标签小型,
        displayLargeEmphasized = 显示大型强调,
        displayMediumEmphasized = 显示中等强调,
        displaySmallEmphasized = 显示小型强调,
        headlineLargeEmphasized = 大标题大型强调,
        headlineMediumEmphasized = 大标题中等强调,
        headlineSmallEmphasized = 大标题小型强调,
        titleLargeEmphasized = 标题大型强调,
        titleMediumEmphasized = 标题中等强调,
        titleSmallEmphasized = 标题小型强调,
        bodyLargeEmphasized = 正文大型强调,
        bodyMediumEmphasized = 正文中等强调,
        bodySmallEmphasized = 正文小型强调,
        labelLargeEmphasized = 标签大型强调,
        labelMediumEmphasized = 标签中等强调,
        labelSmallEmphasized = 标签小型强调,
    )



/** [displayLarge] 的强调版本。 */
val Typography.显示大型强调
    get() = this.displayLargeEmphasized

/** [displayMedium] 的强调版本。 */
val Typography.显示中等强调
    get() = this.displayMediumEmphasized

/** [displaySmall] 的强调版本。 */
val Typography.显示小型强调
    get() = this.displaySmallEmphasized

/** [headlineLarge] 的强调版本。 */
val Typography.大标题大型强调
    get() = this.headlineLargeEmphasized

/** [headlineMedium] 的强调版本。 */
val Typography.大标题中等强调
    get() = this.headlineMediumEmphasized

/** [headlineSmall] 的强调版本。 */
val Typography.大标题小型强调
    get() = this.headlineSmallEmphasized

/** [titleLarge] 的强调版本。 */
val Typography.标题大型强调
    get() = this.titleLargeEmphasized

/** [titleMedium] 的强调版本。 */
val Typography.标题中等强调
    get() = this.titleMediumEmphasized

/** [titleSmall] 的强调版本。 */
val Typography.标题小型强调
    get() = this.titleSmallEmphasized

/** [bodyLarge] 的强调版本。 */
val Typography.正文大型强调
    get() = this.bodyLargeEmphasized

/** [bodyMedium] 的强调版本。 */
val Typography.正文中等强调
    get() = this.bodyMediumEmphasized

/** [bodySmall] 的强调版本。 */
val Typography.正文小型强调
    get() = this.bodySmallEmphasized

/** [labelLarge] 的强调版本。 */
val Typography.标签大型强调
    get() = this.labelLargeEmphasized

/** [labelMedium] 的强调版本。 */
val Typography.标签中等强调
    get() = this.labelMediumEmphasized

/** [labelSmall] 的强调版本。 */
val Typography.标签小型强调
    get() = this.labelSmallEmphasized



/**
 * Material Design 字体比例包含一系列对比鲜明的样式，以满足您的产品及其内容的需求。
 *
 * 使用排版使文字清晰易读且美观。Material 的默认字体比例包含对比鲜明且灵活的样式，以支持广泛的使用场景。
 *
 * 字体比例是由字体系统支持的十三种样式的组合。它包含可复用的文本类别，每个类别都有特定的应用场景和含义。
 *
 * 要了解更多关于排版的信息，请参阅[Material Design typography](https://m3.material.io/styles/typography/overview).
 *
 * @param 显示大型 displayLarge 是最大的展示文本。
 * @param 显示中等 displayMedium 是第二大的展示文本。
 * @param 显示小型 displaySmall 是最小的展示文本。
 * @param 大标题大型 headlineLarge 是最大的标题，用于简短、重要的文本或数字。对于标题，您可以选择富有表现力的字体，
 * 例如展示体、手写体或手写风格。这些非常规的字体设计具有细节和复杂性，有助于吸引视线。
 * @param 大标题中等 headlineMedium 是第二大的标题，用于简短、重要的文本或数字。对于标题，您可以选择富有表现力的字体，
 * 例如展示体、手写体或手写风格。这些非常规的字体设计具有细节和复杂性，有助于吸引视线。
 * @param 大标题小型 headlineSmall 是最小的标题，用于简短、重要的文本或数字。对于标题，您可以选择富有表现力的字体，
 * 例如展示体、手写体或手写风格。这些非常规的字体设计具有细节和复杂性，有助于吸引视线。
 * @param 标题大型 titleLarge 是最大的标题文本，通常用于长度较短的中等强调文本。衬线体或无衬线体都适合用于副标题。
 * @param 标题中等 titleMedium 是第二大的标题文本，通常用于长度较短的中等强调文本。衬线体或无衬线体都适合用于副标题。
 * @param 标题小型 titleSmall 是最小的标题文本，通常用于长度较短的中等强调文本。衬线体或无衬线体都适合用于副标题。
 * @param 正文大型 bodyLarge 是最大的正文文本，通常用于长篇写作，因为它非常适合较小的字号。对于较长的文本段落，
 * 建议使用衬线体或无衬线体。
 * @param 正文中等 bodyMedium 是第二大的正文文本，通常用于长篇写作，因为它非常适合较小的字号。对于较长的文本段落，
 * 建议使用衬线体或无衬线体。
 * @param 正文小型 bodySmall 是最小的正文文本，通常用于长篇写作，因为它非常适合较小的字号。对于较长的文本段落，
 * 建议使用衬线体或无衬线体。
 * @param 标签大型 labelLarge 文本是用于不同类型按钮（如文本按钮、轮廓按钮和填充按钮）以及标签页、对话框和卡片中的行动号召。
 * 按钮文本通常使用无衬线体，并采用全大写形式。
 * @param 标签中等 labelMedium 是最小的字号之一。它仅少量用于为图片添加注释或作为标题的引子。
 * @param 标签小型 labelSmall 是最小的字号之一。它仅少量用于为图片添加注释或作为标题的引子。
 */
fun 排版(
    显示大型: TextStyle = typographyTokens.DisplayLarge,
    显示中等: TextStyle = typographyTokens.DisplayMedium,
    显示小型: TextStyle = typographyTokens.DisplaySmall,
    大标题大型: TextStyle = typographyTokens.HeadlineLarge,
    大标题中等: TextStyle = typographyTokens.HeadlineMedium,
    大标题小型: TextStyle = typographyTokens.HeadlineSmall,
    标题大型: TextStyle = typographyTokens.TitleLarge,
    标题中等: TextStyle = typographyTokens.TitleMedium,
    标题小型: TextStyle = typographyTokens.TitleSmall,
    正文大型: TextStyle = typographyTokens.BodyLarge,
    正文中等: TextStyle = typographyTokens.BodyMedium,
    正文小型: TextStyle = typographyTokens.BodySmall,
    标签大型: TextStyle = typographyTokens.LabelLarge,
    标签中等: TextStyle = typographyTokens.LabelMedium,
    标签小型: TextStyle = typographyTokens.LabelSmall,
) =
    Typography(
        displayLarge = 显示大型,
        displayMedium = 显示中等,
        displaySmall = 显示小型,
        headlineLarge = 大标题大型,
        headlineMedium = 大标题中等,
        headlineSmall = 大标题小型,
        titleLarge = 标题大型,
        titleMedium = 标题中等,
        titleSmall = 标题小型,
        bodyLarge = 正文大型,
        bodyMedium = 正文中等,
        bodySmall = 正文小型,
        labelLarge = 标签大型,
        labelMedium = 标签中等,
        labelSmall = 标签小型,
    )


/** 返回此 Typography 的副本，可选择性地覆盖部分值。 */
fun Typography.复制(
    显示大型: TextStyle = this.displayLarge,
    显示中等: TextStyle = this.displayMedium,
    显示小型: TextStyle = this.displaySmall,
    大标题大型: TextStyle = this.headlineLarge,
    大标题中等: TextStyle = this.headlineMedium,
    大标题小型: TextStyle = this.headlineSmall,
    标题大型: TextStyle = this.titleLarge,
    标题中等: TextStyle = this.titleMedium,
    标题小型: TextStyle = this.titleSmall,
    正文大型: TextStyle = this.bodyLarge,
    正文中等: TextStyle = this.bodyMedium,
    正文小型: TextStyle = this.bodySmall,
    标签大型: TextStyle = this.labelLarge,
    标签中等: TextStyle = this.labelMedium,
    标签小型: TextStyle = this.labelSmall,
    显示大型强调: TextStyle = this.displayLargeEmphasized,
    显示中等强调: TextStyle = this.displayMediumEmphasized,
    显示小型强调: TextStyle = this.displaySmallEmphasized,
    大标题大型强调: TextStyle = this.headlineLargeEmphasized,
    大标题中等强调: TextStyle = this.headlineMediumEmphasized,
    大标题小型强调: TextStyle = this.headlineSmallEmphasized,
    标题大型强调: TextStyle = this.titleLargeEmphasized,
    标题中等强调: TextStyle = this.titleMediumEmphasized,
    标题小型强调: TextStyle = this.titleSmallEmphasized,
    正文大型强调: TextStyle = this.bodyLargeEmphasized,
    正文中等强调: TextStyle = this.bodyMediumEmphasized,
    正文小型强调: TextStyle = this.bodySmallEmphasized,
    标签大型强调: TextStyle = this.labelLargeEmphasized,
    标签中等强调: TextStyle = this.labelMediumEmphasized,
    标签小型强调: TextStyle = this.labelSmallEmphasized,
): Typography =
    Typography(
        displayLarge = 显示大型,
        displayMedium = 显示中等,
        displaySmall = 显示小型,
        headlineLarge = 大标题大型,
        headlineMedium = 大标题中等,
        headlineSmall = 大标题小型,
        titleLarge = 标题大型,
        titleMedium = 标题中等,
        titleSmall = 标题小型,
        bodyLarge = 正文大型,
        bodyMedium = 正文中等,
        bodySmall = 正文小型,
        labelLarge = 标签大型,
        labelMedium = 标签中等,
        labelSmall = 标签小型,
        displayLargeEmphasized = 显示大型强调,
        displayMediumEmphasized = 显示中等强调,
        displaySmallEmphasized = 显示小型强调,
        headlineLargeEmphasized = 大标题大型强调,
        headlineMediumEmphasized = 大标题中等强调,
        headlineSmallEmphasized = 大标题小型强调,
        titleLargeEmphasized = 标题大型强调,
        titleMediumEmphasized = 标题中等强调,
        titleSmallEmphasized = 标题小型强调,
        bodyLargeEmphasized = 正文大型强调,
        bodyMediumEmphasized = 正文中等强调,
        bodySmallEmphasized = 正文小型强调,
        labelLargeEmphasized = 标签大型强调,
        labelMediumEmphasized = 标签中等强调,
        labelSmallEmphasized = 标签小型强调,
    )


/** 返回此 Typography 的副本，可选择性地覆盖部分值。 */
fun Typography.复制(
    显示大型: TextStyle = this.displayLarge,
    显示中等: TextStyle = this.displayMedium,
    显示小型: TextStyle = this.displaySmall,
    大标题大型: TextStyle = this.headlineLarge,
    大标题中等: TextStyle = this.headlineMedium,
    大标题小型: TextStyle = this.headlineSmall,
    标题大型: TextStyle = this.titleLarge,
    标题中等: TextStyle = this.titleMedium,
    标题小型: TextStyle = this.titleSmall,
    正文大型: TextStyle = this.bodyLarge,
    正文中等: TextStyle = this.bodyMedium,
    正文小型: TextStyle = this.bodySmall,
    标签大型: TextStyle = this.labelLarge,
    标签中等: TextStyle = this.labelMedium,
    标签小型: TextStyle = this.labelSmall,
): Typography =
    Typography(
        displayLarge = 显示大型,
        displayMedium = 显示中等,
        displaySmall = 显示小型,
        headlineLarge = 大标题大型,
        headlineMedium = 大标题中等,
        headlineSmall = 大标题小型,
        titleLarge = 标题大型,
        titleMedium = 标题中等,
        titleSmall = 标题小型,
        bodyLarge = 正文大型,
        bodyMedium = 正文中等,
        bodySmall = 正文小型,
        labelLarge = 标签大型,
        labelMedium = 标签中等,
        labelSmall = 标签小型,
    )


private val typographyTokens: TypographyTokens = TypographyTokens()
