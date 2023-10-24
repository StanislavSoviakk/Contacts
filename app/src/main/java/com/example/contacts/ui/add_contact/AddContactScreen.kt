package com.example.contacts.ui.add_contact

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contacts.R
import com.example.contacts.domain.model.Contact
import com.example.contacts.domain.model.Status
import org.koin.androidx.compose.koinViewModel

private const val PREFETCH_DISTANCE = 5

@Composable
fun AddContact(viewModel: AddContactViewModel = koinViewModel()) {

    val state = viewModel.state.value

    val onContactClick = remember {
        { contact: Contact -> viewModel.onContactClick(contact) }
    }

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        itemsIndexed(state.contactsList) { index, contact ->
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .clickable(onClick = { onContactClick(contact) })
            ) {
                Text(
                    text = "${contact.firstName} ${contact.lastName}",
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 20.sp)
                )
            }
            if (index == state.contactsList.size - PREFETCH_DISTANCE) {
                viewModel.loadUsers()
            }
        }
    }
    if (state.isStatusDialogExpanded) {
        val saveContact = remember {
            { status: Status -> viewModel.addContactToDB(status = status) }
        }

        AlertDialog(onDismissRequest = viewModel::collapseDialog,
            title = { Text(text = stringResource(id = R.string.dialog_select_status_title)) },
            text = {
                Row {
                    TextButton(onClick = { saveContact(Status.WORK) }) {
                        Text(text = stringResource(id = R.string.work))
                    }
                    TextButton(onClick = { saveContact(Status.FRIEND) }) {
                        Text(text = stringResource(id = R.string.friend))
                    }
                    TextButton(onClick = { saveContact(Status.FAMILY) }) {
                        Text(text = stringResource(id = R.string.family))
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = viewModel::collapseDialog
                ) {
                    Text(stringResource(id = R.string.dismiss))
                }
            })
    }
}