package com.dxyc.zwkfb.组件

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import javafx.embed.swing.JFXPanel
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.control.TextField

@Composable
fun javafxPanel()  {
    SwingPanel(
        factory = {
            JFXPanel().apply {
                val titleLabel = Label("用户注册")
                titleLabel.style = "-fx-font-size: 24px; -fx-font-weight: bold;"

                val nameLabel = Label("姓名：")
                val nameField = TextField()
                nameField.promptText = "请输入姓名"

                val emailLabel = Label("邮箱：")
                val emailField = TextField()
                emailField.promptText = "请输入邮箱"

                val addressLabel = Label("地址：")
                val addressArea = TextArea()
                addressArea.promptText = "请输入详细地址"
                addressArea.prefRowCount = 3

                addressArea.style = """
                    -fx-font-size: 14px;
                    -fx-control-inner-background: white;
                """.trimIndent()

                val passwordLabel = Label("密码：")
                val passwordField = TextField()
                passwordField.promptText = "请输入密码"

                val registerButton = javafx.scene.control.Button("注册")
                registerButton.style = "-fx-font-size: 16px; -fx-padding: 10px 30px; -fx-background-color: #007bff; -fx-text-fill: white; -fx-background-radius: 5px;"

                val formVBox = javafx.scene.layout.VBox(10.0,
                    titleLabel,
                    nameLabel,
                    nameField,
                    emailLabel,
                    emailField,
                    addressLabel,
                    addressArea,
                    passwordLabel,
                    passwordField,
                    registerButton
                )

                formVBox.alignment = Pos.CENTER_LEFT
                formVBox.style = "-fx-padding: 30px; -fx-background-color: #f5f5f5;"

                this.scene = Scene(formVBox, 400.0, 600.0)
            }
        },
        modifier = Modifier.fillMaxSize(),
    )
}
