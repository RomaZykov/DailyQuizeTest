package com.example.dailyquizetest.presentation.features.quiz.model

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dailyquizetest.R
import com.example.dailyquizetest.presentation.common.Categories
import com.example.dailyquizetest.presentation.common.Difficulties
import com.example.dailyquizetest.presentation.features.quiz.QuizUiState
import com.example.dailyquizetest.presentation.ui.theme.DailyQuizTheme

data class Filters(
    val categories: List<Categories>,
    val difficulties: List<Difficulties>
) : QuizUiState {
    @Composable
    override fun Display() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DailyQuizTheme.colorScheme.primary)
                .padding(top = DailyQuizTheme.dimensions.topPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(40.dp))
                    .background(DailyQuizTheme.colorScheme.secondary),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TitleText()
                DescriptionText()
                Categories(categories)
                Difficulties(difficulties)
                NextButton()
            }
        }
    }

    @Composable
    private fun TitleText() {
        Text(
            modifier = Modifier.padding(top = 16.dp, bottom = 4.dp),
            text = stringResource(R.string.almost_done),
            style = DailyQuizTheme.typography.title
        )
    }

    @Composable
    private fun DescriptionText() {
        Text(
            modifier = Modifier.padding(8.dp),
            text = stringResource(R.string.category_description), textAlign = TextAlign.Center
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun Categories(categories: List<Categories>) {
        // TODO: DRY
        var expanded by rememberSaveable { mutableStateOf(false) }
        val label = stringResource(R.string.category_menu_text)
        var selectedCategory by rememberSaveable { mutableStateOf(label) }
        ExposedDropdownMenuBox(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .menuAnchor(MenuAnchorType.PrimaryNotEditable)
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        expanded = true
                    },
                value = selectedCategory,
                onValueChange = {
                    selectedCategory = it
                },
                textStyle = DailyQuizTheme.typography.dropDownItem,
                label = {
                    if (selectedCategory != label) {
                        Text(label)
                    }
                },
                readOnly = true,
                trailingIcon = {
                    Icon(painter = painterResource(R.drawable.outline_keyboard_arrow_down), null)
                }
            )

            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                categories.forEach {
                    DropdownMenuItem(
                        text = {
                            Text(it.categoryName)
                        },
                        onClick = {
                            selectedCategory = it.categoryName
                            expanded = false
                        })
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun Difficulties(difficulties: List<Difficulties>) {
        // TODO: DRY
        var expanded by rememberSaveable { mutableStateOf(false) }
        val label = stringResource(R.string.difficulty_menu_text)
        var selectedDifficulty by rememberSaveable { mutableStateOf(label) }
        ExposedDropdownMenuBox(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .menuAnchor(MenuAnchorType.PrimaryNotEditable)
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        expanded = true
                    },
                value = selectedDifficulty,
                onValueChange = {
                    selectedDifficulty = it
                },
                textStyle = DailyQuizTheme.typography.dropDownItem,
                label = {
                    if (selectedDifficulty != label) {
                        Text(text = label, color = DailyQuizTheme.colorScheme.tertiary)
                    }
                },
                readOnly = true,
                trailingIcon = {
                    Icon(painter = painterResource(R.drawable.outline_keyboard_arrow_down), null)
                }
            )

            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                difficulties.forEach {
                    DropdownMenuItem(
                        text = {
                            Text(it.level)
                        },
                        onClick = {
                            selectedDifficulty = it.level
                            expanded = false
                        })
                }
            }
        }
    }

    @Composable
    private fun NextButton() {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 38.dp, vertical = 32.dp),
            shape = RoundedCornerShape(12.dp),
            enabled = false,
            onClick = {

            }) {
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = stringResource(R.string.start_quiz_button_text)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun FiltersPreview() {
    Filters(Categories.entries.toList(), emptyList()).Display()
}
