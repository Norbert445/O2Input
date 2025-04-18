package com.example.o2input.ui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.o2input.R
import com.example.o2input.ui.theme.LocalColors
import com.example.o2input.ui.theme.LocalRadius
import com.example.o2input.ui.theme.LocalSpacing
import com.example.o2input.ui.theme.LocalTypography
import com.example.o2input.ui.theme.O2InputTheme

@Composable
fun InputView(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTypography.current.bodyM.copy(
        color = LocalColors.current.contentOnNeutralXXHigh
    ),
    label: String? = null,
    placeholder: String = "",
    supportingText: String? = null,
    isOptional: Boolean = true,
    isError: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            label?.let {
                Text(
                    text = it,
                    color = if (isError) LocalColors.current.contentOnNeutralDanger else LocalColors.current.contentOnNeutralXXHigh,
                    style = LocalTypography.current.labelM
                )
                Spacer(modifier = Modifier.width(LocalSpacing.current.xs))
            }

            if (isOptional) {
                Text(
                    text = stringResource(R.string.optional_title),
                    color = LocalColors.current.contentOnNeutralLow,
                    style = LocalTypography.current.labelS
                )
            }
        }

        Spacer(Modifier.height(LocalSpacing.current.xs))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = textStyle,
            placeholder = {
                Text(
                    text = placeholder,
                    style = LocalTypography.current.bodyM,
                    color = LocalColors.current.contentOnNeutralLow,
                )
            },
            supportingText = supportingText?.let {
                { Text(supportingText, style = LocalTypography.current.labelS) }
            },
            isError = isError,
            modifier = Modifier
                .fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = LocalColors.current.surfaceBrand,
                unfocusedBorderColor = LocalColors.current.surfaceXHigh,
                errorBorderColor = LocalColors.current.surfaceDanger
            ),
            shape = RoundedCornerShape(LocalRadius.current.input),
            trailingIcon = trailingIcon,
            leadingIcon = leadingIcon,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InputPreview() {
    O2InputTheme {
        InputView(
            "Input",
            {},
            label = "Input",
            placeholder = "Placeholder",
            isError = false
        )
    }
}