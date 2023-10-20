package com.example.contacts.ui.profile_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.contacts.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(viewModel: ProfileViewModel = koinViewModel()) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            modifier = Modifier
                .clip(CircleShape)
                .size(100.dp),
            model = state.picture,
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(16.dp))

        Text(text = stringResource(id = R.string.first_name, state.firstName))
        Spacer(modifier = Modifier.size(8.dp))

        Text(text = stringResource(id = R.string.last_name, state.lastName))
        Spacer(modifier = Modifier.size(8.dp))

        Text(text = stringResource(id = R.string.phone_number, state.phoneNumber))
        Spacer(modifier = Modifier.size(8.dp))

        Text(text = stringResource(id = R.string.email, state.email))
        Spacer(modifier = Modifier.size(8.dp))

        Text(text = stringResource(id = R.string.birth_date, state.birthDate))
        Spacer(modifier = Modifier.size(16.dp))

        Button(
            onClick = viewModel::editProfile,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.edit_profile))
        }
    }
}