package com.mrjalal.autofill.login.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mrjalal.autofill.login.presentation.viewModel.LoginViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {

    var (userName, setUserName) = remember {
        mutableStateOf("")
    }

    var (password, setPassword) = remember {
        mutableStateOf("")
    }

    val onUserNameValueChanged: (String) -> Unit = { value -> setUserName(value) }

    val onPasswordValueChanged: (String) -> Unit = { value -> setPassword(value) }

    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Login") }) },
    ) {
        ModalBottomSheetLayout(
            sheetState = bottomSheetState,
            sheetContent = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(300.dp)
                )
            }
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = userName,
                    onValueChange = onUserNameValueChanged,
                    placeholder = {
                        Text(text = "User Name")
                    },
                )
                Spacer(
                    modifier = Modifier.size(16.dp)
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = onPasswordValueChanged,
                    placeholder = {
                        Text(text = "Password")
                    }
                )
                Spacer(modifier = Modifier.size(16.dp))
                Button(
                    onClick = {
                        scope.launch { bottomSheetState.show() }
                    }
                ) {
                    Text(text = "Toggle bottom sheet")
                }
            }
        }
    }

//    val scope = rememberCoroutineScope()
//    val scaffoldState = rememberBottomSheetScaffoldState()
//    BottomSheetScaffold(
//        sheetContent = {
//            Box(
//                Modifier.fillMaxWidth().height(128.dp),
//                contentAlignment = Alignment.Center
//            ) {
//                Text("Swipe up to expand sheet")
//            }
//            Column(
//                Modifier.fillMaxWidth().padding(64.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text("Sheet content")
//                Spacer(Modifier.height(20.dp))
//                Button(
//                    onClick = {
//                        scope.launch { scaffoldState.bottomSheetState.collapse() }
//                    }
//                ) {
//                    Text("Click to collapse sheet")
//                }
//            }
//        },
//        scaffoldState = scaffoldState,
//        topBar = {
//            TopAppBar(
//                title = { Text("Bottom sheet scaffold") },
//                navigationIcon = {
//                    IconButton(onClick = { scope.launch { scaffoldState.drawerState.open() } }) {
//                        Icon(Icons.Default.Menu, contentDescription = "Localized description")
//                    }
//                }
//            )
//        },
//        floatingActionButton = {
//            var clickCount by remember { mutableStateOf(0) }
//            FloatingActionButton(
//                onClick = {
//                    // show snackbar as a suspend function
//                    scope.launch {
//                        scaffoldState.snackbarHostState.showSnackbar("Snackbar #${++clickCount}")
//                    }
//                }
//            ) {
//                Icon(Icons.Default.Favorite, contentDescription = "Localized description")
//            }
//        },
//        floatingActionButtonPosition = FabPosition.End,
//        sheetPeekHeight = 128.dp,
//        drawerContent = {
//            Column(
//                Modifier.fillMaxWidth().padding(16.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text("Drawer content")
//                Spacer(Modifier.height(20.dp))
//                Button(onClick = { scope.launch { scaffoldState.drawerState.close() } }) {
//                    Text("Click to close drawer")
//                }
//            }
//        }
//    ) { innerPadding ->
//        LazyColumn(contentPadding = innerPadding) {
//            items(100) {
//                Box(
//                    Modifier
//                        .fillMaxWidth()
//                        .height(50.dp)
//                        .background(Color.Blue)
//                )
//            }
//        }
//    }

//    val state = rememberModalBottomSheetState(
//        initialValue = ModalBottomSheetValue.Hidden,
//    )
//    val scope = rememberCoroutineScope()
//    ModalBottomSheetLayout(
//        sheetState = state,
//        sheetContent = {
//            LazyColumn {
//                items(50) {
//                    ListItem(
//                        text = { Text("Item $it") },
//                        icon = {
//                            Icon(
//                                Icons.Default.Favorite,
//                                contentDescription = "Localized description"
//                            )
//                        }
//                    )
//                }
//            }
//        }
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Spacer(Modifier.height(20.dp))
//            Button(onClick = { scope.launch { state.show() } }) {
//                Text("Click to show sheet")
//            }
//        }
//    }

//    val drawerState = rememberDrawerState(DrawerValue.Closed)
// //    val scope = rememberCoroutineScope()
//    ModalDrawer(
//        drawerState = drawerState,
//        drawerContent = {
//            Button(
//                modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 16.dp),
//                onClick = { scope.launch { drawerState.close() } },
//                content = { Text("Close Drawer") }
//            )
//        },
//        content = {
//            Column(
//                modifier = Modifier.fillMaxSize().padding(16.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(text = if (drawerState.isClosed) ">>> Swipe >>>" else "<<< Swipe <<<")
//                Spacer(Modifier.height(20.dp))
//                Button(onClick = { scope.launch { drawerState.open() } }) {
//                    Text("Click to open")
//                }
//            }
//        }
//    )

//    var selectedItem by remember { mutableStateOf(0) }
//    val items = listOf("Home", "Search", "Settings")
//    val icons = listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Settings)
//    NavigationRail {
//        items.forEachIndexed { index, item ->
//            NavigationRailItem(
//                icon = { Icon(icons[index], contentDescription = item) },
//                label = { Text(item) },
//                selected = selectedItem == index,
//                onClick = { selectedItem = index }
//            )
//        }
//    }
}
