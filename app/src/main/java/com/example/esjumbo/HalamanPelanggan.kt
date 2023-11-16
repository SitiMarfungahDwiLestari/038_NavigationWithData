package com.example.esjumbo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanPelanggan(
    onNextButtonClicked: (MutableList<String>) -> Unit,
    onCancelButtonClicked: () -> Unit
) {
    var nama by rememberSaveable { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var listData: MutableList<String> = mutableListOf(nama, noHp, alamat)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = stringResource(id = R.string.judul),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold )
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)))
        OutlinedTextField(
            placeholder = { Text("Masukkan Nama") },
            value = nama,
            singleLine = true,
            onValueChange = { nama = it },
            label = {
                Text(
                    text = stringResource(
                        id = R.string.nama
                    )
                )
            })
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
        OutlinedTextField(
            placeholder = { Text("Masukkan Nomor HP") },
            value = noHp,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { noHp = it },
            label = {
                Text(
                    text = stringResource(
                        id = R.string.no
                    )
                )
            })
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
        OutlinedTextField(
            placeholder = { Text("Masukkan Alamat") },
            value = alamat,
            singleLine = true,
            onValueChange = { alamat = it },
            label = {
                Text(
                    text = stringResource(
                        id = R.string.alamat
                    )
                )
            })
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
                .weight(1f, false),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ){
            OutlinedButton(modifier = Modifier.weight(1f), onClick = onCancelButtonClicked) {
                Text(stringResource(R.string.cancel))
            }
            Button(
                modifier = Modifier.weight(1f),
                enabled = nama.isNotEmpty() && noHp.isNotEmpty() && alamat.isNotEmpty(),
                onClick = { onNextButtonClicked(listData) }) {
                Text(text = stringResource(id = R.string.next))
            }
        }
    }
}
