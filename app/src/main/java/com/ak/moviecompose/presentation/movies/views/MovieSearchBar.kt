package com.ak.moviecompose.presentation.movies.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieSearchBar(
    modifier: Modifier = Modifier,
    hint: String ="",
    onSearch: (String) -> Unit = {}
) {
    var text by remember { mutableStateOf("") }

    var isHintDisplayed by remember { mutableStateOf(hint != "") }



    Box(modifier = modifier) {
        TextField(value = text,
            onValueChange ={ text = it },
            keyboardActions = KeyboardActions(onDone = {
                onSearch(text)
            }),
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp)
                .onFocusChanged {
                    isHintDisplayed = it.isFocused != true && text.isEmpty()
                }
        )

        if (isHintDisplayed){
            Text(text = hint,
                color = Color.LightGray,
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 17.dp)
            )

        }
    }

}

@Preview
@Composable
fun MovieSearchPreview() {

    MovieSearchBar(hint = "Search"){

    }

}

