package com.example.contacts.ui.contacts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contacts.R
import com.example.contacts.domain.model.Contact
import com.example.contacts.domain.model.Status
import kotlinx.collections.immutable.PersistentList
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Contacts(
    viewModel: ContactsViewModel = koinViewModel()
) {

    val state = viewModel.state.value

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            val changeSearchText = remember {
                { text: String -> viewModel.changeSearchText(text) }
            }
            OutlinedTextField(
                value = state.searchText,
                onValueChange = changeSearchText,
                label = { Text(stringResource(id = R.string.search_hint)) },
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp)
            )

            Box(modifier = Modifier.padding(start = 16.dp)) {
                FilterButton(
                    viewModel::expandFilterMenu,
                    viewModel::collapseFilterMenu,
                    viewModel::selectStatus,
                    state.isFilterExpanded
                )
            }
        }
        ContactsList(state.filteredContacts ?: state.contactsList, state.selectedStatus)
        AddContactButton(viewModel::openAddContactScreen)
    }
}

@Composable
fun ContactsList(filteredContacts: PersistentList<Contact>, selectedStatus: Status) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(filteredContacts.filter {
            it.status == selectedStatus || selectedStatus == Status.NO_STATUS
        }) { contact ->
            Row(modifier = Modifier
                .padding(4.dp)
                .clickable {
                    //Open Contact details screen
                }) {
                Text(
                    text = "${contact.firstName} ${contact.lastName}",
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 20.sp)
                )
            }
        }
    }
}

@Composable
fun FilterButton(
    onExpandFilterMenu: () -> Unit,
    onCollapseFilterMenu: () -> Unit,
    onSelectStatus: (Status) -> Unit,
    isFilterExpanded: Boolean
) {
    val selectStatus = remember {
        onSelectStatus
    }
    Button(onClick = onExpandFilterMenu, modifier = Modifier.height(56.dp)) {
        Text(stringResource(id = R.string.filter))
    }
    DropdownMenu(
        expanded = isFilterExpanded,
        onDismissRequest = onCollapseFilterMenu
    ) {
        DropdownMenuItem(onClick = {
            selectStatus(Status.NO_STATUS)
        }, text = {
            Text(stringResource(id = R.string.all))
        })
        DropdownMenuItem(onClick = {
            selectStatus(Status.WORK)
        }, text = {
            Text(stringResource(id = R.string.work))
        })
        DropdownMenuItem(onClick = {
            selectStatus(Status.FRIEND)
        }, text = {
            Text(stringResource(id = R.string.friend))
        })
        DropdownMenuItem(onClick = {
            selectStatus(Status.FAMILY)
        }, text = {
            Text(stringResource(id = R.string.family))
        })
    }
}

@Composable
fun AddContactButton(onFloatingButtonClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        FloatingActionButton(
            onClick = onFloatingButtonClick,
            shape = CircleShape,
        ) {
            Icon(Icons.Filled.Add, null)
        }
    }
}
