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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class StudentScore(
    val name: String,
    val score: Double?
)

@Composable
fun Bai3() {
    val students = listOf(
        StudentScore("Nguyễn Văn An", 9.0),
        StudentScore("Trần Thị Bình", 7.2),
        StudentScore("Lê Minh Chi", null),
        StudentScore("Phạm Quốc Dũng", 4.5),
        StudentScore("Võ Thanh Em", 5.8)
    )

    var totalScore = 0.0
    var countScore = 0
    var gioiCount = 0
    var noScoreCount = 0
    var maxScore = 0.0

    for (sv in students) {
        if (sv.score == null) {
            noScoreCount++
        } else {
            totalScore += sv.score
            countScore++
            if (sv.score >= 8.0) gioiCount++
            if (sv.score > maxScore) maxScore = sv.score
        }
    }
    val avg = if (countScore > 0) totalScore / countScore else 0.0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6))
            .padding(16.dp)
    ) {
        Text(
            text = "Bảng điểm lớp",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1E3A8A), RoundedCornerShape(8.dp))
                .padding(12.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E3A8A))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Điểm trung bình lớp", color = Color.White.copy(alpha = 0.7f), fontSize = 13.sp)
                Text(
                    text = String.format("%.2f", avg),
                    color = Color.White,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Column {
                        Text("Giỏi", color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp)
                        Text("$gioiCount", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                    Column {
                        Text("Chưa có điểm", color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp)
                        Text("$noScoreCount", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                    Column {
                        Text("Cao nhất", color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp)
                        Text("$maxScore", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text("DANH SÁCH - ${students.size} SINH VIÊN", fontSize = 12.sp, color = Color.Gray, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            items(students) { sv ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(sv.name, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                            Text(
                                text = if (sv.score == null) "Chưa có điểm" else xepLoai(sv.score),
                                fontSize = 12.sp,
                                color = if (sv.score == null) Color.Gray else mauXepLoai(xepLoai(sv.score))
                            )
                        }
                        Text(
                            text = sv.score?.toString() ?: "—",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF111827)
                        )
                    }
                }
            }
        }
    }
}