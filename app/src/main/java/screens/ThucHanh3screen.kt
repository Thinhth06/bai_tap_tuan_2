package com.example.bai_tap_tuan_2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ThucHanh3screen() {
    var soThuNhat by remember { mutableStateOf("") }
    var soThuHai by remember { mutableStateOf("") }
    var phepToan by remember { mutableStateOf("+") }
    var ketQua by remember { mutableStateOf("") }

    fun tinhToan() {
        val a = soThuNhat.toDoubleOrNull()
        val b = soThuHai.toDoubleOrNull()
        ketQua = if (a == null || b == null) {
            "Vui lòng nhập số hợp lệ"
        } else {
            when (phepToan) {
                "+" -> (a + b).toString()
                "-" -> (a - b).toString()
                "*" -> (a * b).toString()
                "/" -> if (b == 0.0) "Không chia được cho 0" else (a / b).toString()
                else -> "Lỗi"
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text("Thực hành 03", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            value = soThuNhat,
            onValueChange = { soThuNhat = it },
            label = { Text("Số thứ nhất") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val operations = listOf(
                "+" to Color(0xFFEF4444),
                "-" to Color(0xFFF59E0B),
                "*" to Color(0xFF6366F1),
                "/" to Color(0xFF111827)
            )
            operations.forEach { (op, color) ->
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .background(
                            color = if (phepToan == op) color else color.copy(alpha = 0.3f),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .clickable {
                            phepToan = op
                            tinhToan()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(op, color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = soThuHai,
            onValueChange = { soThuHai = it },
            label = { Text("Số thứ hai") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Kết quả: $ketQua",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF111827),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
    }
}

