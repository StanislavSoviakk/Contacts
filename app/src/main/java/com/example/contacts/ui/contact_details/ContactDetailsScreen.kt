package com.example.contacts.ui.contact_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.contacts.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun ContactDetailsScreen(viewModel: ContactDetailsViewModel = koinViewModel(), uuid: String?) {

    val state = viewModel.uiState

    LaunchedEffect(key1 = uuid) {
        viewModel.loadContact(uuid)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = stringResource(id = R.string.category, state.contact.status))
        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = state.contact.picture,
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = stringResource(
                        id = R.string.name,
                        state.contact.firstName,
                        state.contact.lastName
                    )
                )
                Text(text = stringResource(id = R.string.phone_number, state.contact.phoneNumber))
                Text(text = stringResource(id = R.string.email, state.contact.email))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = viewModel::expandDeleteContactDialog,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = stringResource(id = R.string.delete_button_text))
        }
    }

    if (state.isDeleteContactDialogExpanded) {
        AlertDialog(
            onDismissRequest = viewModel::collapseDeleteContactDialog,
            title = { Text(text = stringResource(id = R.string.delete_contact_button_title)) },
            text = { Text(text = stringResource(id = R.string.delete_contact_button_text)) },
            confirmButton = {
                Button(onClick = viewModel::deleteContact) {
                    Text(text = stringResource(id = R.string.confirm))
                }
            },
            dismissButton = {
                Button(onClick = viewModel::collapseDeleteContactDialog) {
                    Text(text = stringResource(id = R.string.cancel))
                }
            }
        )
    }

}