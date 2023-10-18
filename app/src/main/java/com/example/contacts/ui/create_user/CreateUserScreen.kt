package com.example.contacts.ui.create_user

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.contacts.R
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateUserScreen(viewModel: CreateUserViewModel = koinViewModel()) {
    val scrollState = rememberScrollState()

    val state = viewModel.state
    val user = state.value.currentUser

    val getPicture =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            viewModel.setPicture(uri.toString())
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.padding(bottom = 16.dp), contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(100.dp),
                model = user.picture,
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
        }

        OutlinedTextField(
            value = user.firstName,
            onValueChange = { viewModel.changeFirstName(it) },
            label = { Text(stringResource(id = R.string.first_name_label)) },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = user.lastName,
            onValueChange = { viewModel.changeLastName(it) },
            label = { Text(stringResource(id = R.string.last_name_label)) },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = user.phoneNumber,
            onValueChange = { viewModel.changeNumber(it) },
            label = { Text(stringResource(id = R.string.phone_number_label)) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        OutlinedTextField(
            value = user.email,
            onValueChange = { viewModel.changeEmail(it) },
            label = { Text(stringResource(id = R.string.email_label)) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        OutlinedTextField(
            value = user.birthDate,
            onValueChange = { viewModel.changeBirthday(it) },
            label = { Text(stringResource(id = R.string.birth_date_label)) },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { getPicture.launch("image/*") },
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.select_image_button_text))
        }

        Button(
            onClick = {
                viewModel.saveUser(user)
            }, modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = stringResource(id = R.string.submit_button_text))
        }
    }
}