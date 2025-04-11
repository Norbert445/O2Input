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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.o2input.R
import com.example.o2input.ui.theme.LocalCustomColorsPalette
import com.example.o2input.ui.theme.LocalRadius
import com.example.o2input.ui.theme.LocalSpacing
import com.example.o2input.ui.theme.LocalTypography
import com.example.o2input.ui.theme.O2InputTheme

@Composable
fun InputView(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String = "",
    isOptional: Boolean = true,
    isError: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            label?.let {
                Text(
                    text = it,
                    color = if (isError) LocalCustomColorsPalette.current.contentOnNeutralDanger else LocalCustomColorsPalette.current.contentOnNeutralXXHigh,
                    style = LocalTypography.current.labelM
                )
                Spacer(modifier = Modifier.width(LocalSpacing.current.xs))
            }

            if (isOptional) {
                Text(
                    text = stringResource(R.string.optional_title),
                    color = LocalCustomColorsPalette.current.contentOnNeutralLow,
                    style = LocalTypography.current.labelS
                )
            }
        }

        Spacer(Modifier.height(LocalSpacing.current.xs))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = LocalTypography.current.bodyM.copy(
                color = LocalCustomColorsPalette.current.contentOnNeutralXXHigh
            ),
            placeholder = {
                Text(
                    text = placeholder,
                    style = LocalTypography.current.bodyM,
                    color = LocalCustomColorsPalette.current.contentOnNeutralLow,
                )
            },
            isError = isError,
            modifier = Modifier
                .fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = LocalCustomColorsPalette.current.surfaceBrand,
                unfocusedBorderColor = LocalCustomColorsPalette.current.surfaceXHigh,
                errorBorderColor = LocalCustomColorsPalette.current.surfaceDanger
            ),
            shape = RoundedCornerShape(LocalRadius.current.input),
            trailingIcon = trailingIcon,
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
            "",
            {},
            label = "Input",
            placeholder = "Placeholder",
            isError = false
        )
    }
}