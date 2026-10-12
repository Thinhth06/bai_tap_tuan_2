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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun xepLoai(diem: Double): String {
    return when {
        diem < 0 || diem > 10 -> "Không hợp lệ"
        diem >= 8.0 -> "Giỏi"
        diem >= 6.5 -> "Khá"
        diem >= 5.0 -> "Trung bình"
        else -> "Yếu"
    }
}

fun mauXepLoai(loai: String): Color {
    return when (loai) {
        "Giỏi" -> Color(0xFF10B981)
        "Khá" -> Color(0xFF3B82F6)
        "Trung bình" -> Color(0xFFF59E0B)
        "Yếu" -> Color(0xFFEF4444)
        else -> Color.Gray
    }
}

@Composable
fun Bai2() {
    val diem = 8.5
    val loai = xepLoai(diem)
    val testScores = listOf(9.0, 7.0, 5.5, 3.0, 11.0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6))
            .padding(16.dp)
    ) {
        Text(
            text = "Xếp loại học lực",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1E3A8A), RoundedCornerShape(8.dp))
                .padding(12.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Điểm trung bình", fontSize = 14.sp, color = Color.Gray)
                Text("$diem", fontSize = 48.sp, fontWeight = FontWeight.Bold, color = Color(0xFF111827))
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = loai,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = mauXepLoai(loai),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(mauXepLoai(loai).copy(alpha = 0.1f), RoundedCornerShape(8.dp))
                        .padding(12.dp),
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("KIỂM TRA THÊM", fontSize = 12.sp, color = Color.Gray, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            items(testScores) { score ->
                val result = xepLoai(score)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, RoundedCornerShape(6.dp))
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Điểm $score")
                    Text(result, color = mauXepLoai(result), fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}