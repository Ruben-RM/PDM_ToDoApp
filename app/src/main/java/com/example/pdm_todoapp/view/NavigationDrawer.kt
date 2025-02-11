package com.example.pdm_todoapp.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.example.pdm_todoapp.ToDoViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun MyNavigationDrawer(viewModel: ToDoViewModel, onCloseDrawer: () -> Unit)
{
    val title by viewModel.title.observeAsState("")
    val description by viewModel.description.observeAsState("")
    val date by viewModel.date.observeAsState("")
    val faved by viewModel.faved.observeAsState(false)
    val isAddingEnabled by viewModel.isLoginEnabled.observeAsState(false)

    Column(
        modifier = Modifier.padding(10.dp))
    {
        Spacer(modifier = Modifier.size(16.dp))
        ToDoHeader()
        Spacer(modifier = Modifier.size(16.dp))
        ToDoTitle(title) { viewModel.onTitleChange(it) }
        Spacer(modifier = Modifier.size(16.dp))
        ToDoDescription(description) { viewModel.onDescriptionChange(it) }
        Spacer(modifier = Modifier.size(16.dp))
        ToDoDate{ viewModel.onDateChange(it) }
        Spacer(modifier = Modifier.size(16.dp))
        ToDoFaved(faved) { viewModel.onFavedChange(it) }
        Spacer(modifier = Modifier.size(16.dp))
        AddButton(isAddingEnabled, viewModel, title, description, date, faved)
    }
}

@Composable
fun ToDoHeader()
{
    Text(
        text = "Añadir un ToDo",
        color = Color.White,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Composable
fun ToDoTitle(title: String, function: (String) -> Unit)
{
    Text(
        text = "Título",
        color = Color.White,
        fontSize = 20.sp
    )
    TextField(
        value = title,
        onValueChange = { function(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        placeholder = { Text(text = "Título del ToDo") }
    )
}

@Composable
fun ToDoDescription(description: String, function: (String) -> Unit)
{
    Text(
        text = "Descripción (opcional)",
        color = Color.White,
        fontSize = 20.sp
    )
    TextField(
        value = description,
        onValueChange = { function(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        placeholder = { Text(text = "Descripcion del ToDo") }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoDate(function: (String) -> Unit)
{
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""

    Text(
        text = "Fecha del ToDo",
        color = Color.White,
        fontSize = 20.sp
    )

    OutlinedTextField(
        value = selectedDate,
        onValueChange = {},
        readOnly = true,
        trailingIcon = {
            IconButton(onClick = { showDatePicker = !showDatePicker }) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    tint = Color.Black,
                    contentDescription = "Selecciona una fecha"
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )

    if (showDatePicker)
    {
        Popup(
            onDismissRequest =
            {
                showDatePicker = false
                function(selectedDate) // Se llama aquí a la función del viewModel en vez de en el OnValueChange, porque si no NO FUNCIONA
            },
            alignment = Alignment.TopStart
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = 64.dp)
                    .shadow(elevation = 4.dp)
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(16.dp)
            ){
                DatePicker(
                    state = datePickerState,
                    showModeToggle = false
                )
            }
        }
    }
}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}

@Composable
fun ToDoFaved(faved: Boolean, function: (Boolean) -> Unit)
{
    Row(verticalAlignment = Alignment.CenterVertically)
    {
        Text("¿Marcar el ToDo como favorito?")

        Checkbox(
            checked = faved,
            onCheckedChange = { function(!faved) },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.White,
                uncheckedColor = Color.White,
                checkmarkColor = Color.Black
            )
        )
    }
}

@Composable
fun AddButton(isAddingEnable: Boolean, viewModel: ToDoViewModel, title: String, description: String, date: String, faved: Boolean)
{
    val context = LocalContext.current

    Button(
        onClick = {
            viewModel.addToDo(title, description, date, faved)
            Toast.makeText(context, "El ToDo se ha añadido correctamente", Toast.LENGTH_SHORT).show()
                  },
        enabled = isAddingEnable,
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            disabledContentColor = Color.Black,
            containerColor = Color.White,
            disabledContainerColor = Color.Gray
        )
    ){
        Text(text = "Añadir ToDo")
    }
}