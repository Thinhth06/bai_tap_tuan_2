package com.example.bai_tap_tuan_2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Student(
    val name: String,
    val email: String?,
    val phone: String?
)

@Composable
fun Bai1() {
    val students = listOf(
        Student("Nguyễn Văn An", "an@sv.edu.vn", "0901 234 567"),
        Student("Trần Thị Bình", null, "0912 888 999"),
        Student("Lê Minh Chi", "chi@sv.edu.vn", null),
        Student("Phạm Quốc Dũng", null, null),
        Student("Võ Thanh Em", "em@sv.edu.vn", "0933 111 222")
    )

    var missingEmailCount = 0
    for (sv in students) {
        if (sv.email == null) missingEmailCount++
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6))
            .padding(16.dp)
    ) {
        Text(
            text = "Danh sách sinh viên",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1E3A8A), RoundedCornerShape(8.dp))
                .padding(12.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(students) { sv ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(sv.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        Text(
                            text = "Email: ${sv.email ?: "Chưa cập nhật"}",
                            fontSize = 13.sp,
                            color = if (sv.email == null) Color.Red else Color(0xFF374151)
                        )
                        Text(
                            text = "SĐT: ${sv.phone ?: "Chưa cập nhật"}",
                            fontSize = 13.sp,
                            color = if (sv.phone == null) Color.Red else Color(0xFF374151)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE5E7EB), RoundedCornerShape(8.dp))
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Tổng: ${students.size} sinh viên", fontWeight = FontWeight.Bold)
            Text("Thiếu email: $missingEmailCount", color = Color.Red, fontWeight = FontWeight.Bold)
        }
    }
}