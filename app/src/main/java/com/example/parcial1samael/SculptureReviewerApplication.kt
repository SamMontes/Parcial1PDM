package com.example.parcial1samael

import android.app.Application
import com.example.parcial1samael.data.sculptures
import com.example.parcial1samael.repository.SculptureRepository

class SculptureReviewerApplication: Application() {
 val sculptureRepository: SculptureRepository by lazy {
    SculptureRepository(sculptures)
 }
}