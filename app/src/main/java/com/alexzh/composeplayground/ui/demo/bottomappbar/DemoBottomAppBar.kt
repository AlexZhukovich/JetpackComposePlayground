package com.alexzh.composeplayground.ui.demo.bottomappbar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Archive
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DemoBottomAppBar() {
    val scrollBehavior = BottomAppBarDefaults.exitAlwaysScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.AutoMirrored.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                title = { Text(text = "Lorem ipsum") },
            )
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Outlined.BookmarkBorder, contentDescription = "Bookmark")
                    }
                    IconButton(onClick = { }) {
                        Icon(Icons.Outlined.Archive, contentDescription = "Archive")
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = { }) {
                        Icon(Icons.Outlined.Edit, contentDescription = "Edit")
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .verticalScroll(rememberScrollState()),
            fontSize = 18.sp,
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer at dapibus metus, vel elementum est. Proin rhoncus rutrum auctor. Nullam at mattis est, quis euismod orci. Suspendisse pulvinar mauris in dapibus ornare. Pellentesque leo nunc, efficitur nec auctor sit amet, efficitur vitae mauris. Fusce sit amet quam quis mi dignissim pulvinar ultrices id urna. Sed ac arcu ut lectus laoreet rutrum eu et lorem. Curabitur at lacinia felis. Vivamus porttitor mauris massa, et congue lacus rhoncus eu. Aenean quis mauris pretium, sollicitudin elit vitae, laoreet nulla. Fusce pharetra dui vitae nunc sodales, vitae elementum neque sodales. Aliquam consequat nibh sed justo condimentum, ut scelerisque tortor tempor. Donec gravida neque ut urna dignissim imperdiet. Donec sollicitudin tellus eu nunc cursus porttitor. Nulla non neque a libero sagittis volutpat at id nibh. Curabitur in elit quis turpis mattis interdum tristique pulvinar eros.\n" +
                    "\n" +
                    "Integer lacinia viverra ipsum. Curabitur dictum massa in mi tempor, quis porttitor nisl interdum. Curabitur ac molestie diam. Suspendisse in nunc sodales, vestibulum justo ac, egestas lectus. Sed lobortis tristique nisi nec gravida. Nulla id orci porttitor, pretium nulla non, finibus leo. Pellentesque fermentum mauris sed velit tempor volutpat. Fusce at mi nec felis gravida venenatis facilisis at tortor. Sed cursus tincidunt maximus. Maecenas a convallis libero, vel rhoncus massa.\n" +
                    "\n" +
                    "Duis ultricies elit ac lorem dapibus, quis cursus purus ultricies. Ut sit amet porttitor massa. Nulla euismod iaculis purus, quis cursus est congue nec. Sed consectetur justo in orci ullamcorper, id laoreet mauris suscipit. Fusce dolor eros, congue sed nibh a, sodales dictum enim. Aenean eget aliquam massa. Quisque sit amet rhoncus felis. Nunc finibus lacus tellus, vitae dictum ipsum sollicitudin sit amet. Quisque ullamcorper mauris ipsum, ac mollis neque facilisis porta. Nulla sollicitudin ultrices mollis.\n" +
                    "\n" +
                    "Quisque tempor massa a dolor volutpat, a commodo dolor interdum. Integer at magna quam. Etiam eros dolor, posuere eu accumsan nec, pulvinar vitae neque. Aliquam pretium quam at vehicula elementum. Nam mollis turpis et est ultrices, ut vestibulum magna auctor. Suspendisse ac placerat est, et finibus metus. Nam bibendum ex sed tempus laoreet. Nunc blandit enim ac risus tempor imperdiet congue quis tellus. Sed tempor, tortor non vehicula accumsan, elit est pellentesque leo, ut iaculis purus ipsum vitae nisi. Sed a libero ut ipsum porttitor bibendum ut at nunc.\n" +
                    "\n" +
                    "Ut gravida ante vitae euismod mattis. Duis eu est quis massa tincidunt porttitor. Vivamus eget imperdiet metus. Donec quis sem imperdiet, tristique tellus eget, dictum ex. Phasellus tincidunt lacinia erat, in sagittis dui. Nulla ut mollis justo, eu luctus mauris. Vivamus bibendum, risus vel maximus elementum, nisi ante rhoncus nisi, in dignissim neque arcu sit amet odio. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Morbi quis arcu pharetra, molestie tellus sed, sagittis turpis. Suspendisse sed dignissim eros."
        )
    }
}