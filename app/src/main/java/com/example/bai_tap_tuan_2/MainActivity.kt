package com.example.bai_tap_tuan_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.bai_tap_tuan_2.screens.Bai1
import com.example.bai_tap_tuan_2.screens.Bai2
import com.example.bai_tap_tuan_2.screens.Bai3
import com.example.bai_tap_tuan_2.screens.ThucHanh3screen
import com.example.bai_tap_tuan_2.ui.theme.Bai_tap_tuan_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bai_tap_tuan_2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var selectedTab by remember { mutableStateOf(0) }
                    val tabs = listOf("TH3", "Bài 1", "Bài 2", "Bài 3")

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .systemBarsPadding()   // ← ĐẨY XUỐNG DƯỚI THANH TRẠNG THÁI
                    ) {
                        TabRow(selectedTabIndex = selectedTab) {
                            tabs.forEachIndexed { index, title ->
                                Tab(
                                    selected = selectedTab == index,
                                    onClick = { selectedTab = index },
                                    text = { Text(title) }
                                )
                            }
                        }

                        when (selectedTab) {
                            0 -> ThucHanh3screen()
                            1 -> Bai1()
                            2 -> Bai2()
                            3 -> Bai3()
                        }
                    }
                }
            }
        }
    }
}