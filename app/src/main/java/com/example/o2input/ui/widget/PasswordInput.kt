package com.example.o2input.ui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.o2input.R
import com.example.o2input.ui.theme.LocalColors
import com.example.o2input.ui.theme.LocalSpacing
import com.example.o2input.ui.theme.LocalTypography
import com.example.o2input.ui.theme.O2InputTheme

@Composable
fun PasswordInput(
    password: String,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTypography.current.bodyM.copy(
        color = LocalColors.current.contentOnNeutralXXHigh
    ),
    label: String? = null,
    placeholder: String = "",
    isError: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
    supportingText: String? = null,
    rules: List<Pair<String, Boolean>>? = null,
    validRuleColor: Color = LocalColors.current.surfaceBrand,
    invalidRuleColor: Color = LocalColors.current.contentOnNeutralDanger
) {
    var passwordVisible by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        InputView(
            value = password,
            onValueChange = onPasswordChange,
            modifier = modifier,
            textStyle = textStyle,
            label = label,
            placeholder = placeholder,
            isOptional = false,
            isError = isError,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val icon =
                    if (passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility
                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = icon,
                        contentDescription = description,
                        tint = LocalColors.current.contentOnNeutralLow
                    )
                }
            },
            leadingIcon = leadingIcon,
            supportingText = supportingText,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        val specialCharacters = listOf('?', '=', '#', '/', '%')
        val rulesToShow = rules ?: listOf(
            stringResource(R.string.password_rule_min_length) to (password.length >= 8),
            stringResource(R.string.password_rule_uppercase) to password.any { it.isUpperCase() },
            stringResource(R.string.password_rule_number) to password.any { it.isDigit() },
            stringResource(R.string.password_rule_special_char) to password.any {
                specialCharacters.contains(it)
            }
        )

        if (rulesToShow.isEmpty()) return

        Column(modifier = Modifier.padding(top = LocalSpacing.current.xs)) {
            rulesToShow.forEach { (ruleText, isValid) ->
                val color =
                    if (isValid) validRuleColor else invalidRuleColor

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = if (isValid) Icons.Default.CheckCircle else Icons.Filled.Cancel,
                        contentDescription = null,
                        tint = color
                    )
                    Spacer(modifier = Modifier.width(LocalSpacing.current.xs))
                    Text(
                        text = ruleText,
                        color = color,
                        style = LocalTypography.current.labelS
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PasswordInputPreview() {
    O2InputTheme {
        PasswordInput(
            password = "aaaaaaaaaa",
            onPasswordChange = {},
            label = "Password"
        )
    }
}
