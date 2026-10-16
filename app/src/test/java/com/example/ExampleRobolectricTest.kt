package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.model.AndroidEra
import com.example.ui.viewmodel.AppTab
import com.example.ui.viewmodel.HistoryViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("Android History", appName)
  }

  @Test
  fun `verify releases data loaded properly`() {
    val viewModel = HistoryViewModel()
    val state = viewModel.uiState.value
    assertTrue("Releases should not be empty", state.releases.isNotEmpty())
    assertTrue("Should include Android 1.0", state.releases.any { it.versionName == "1.0" })
    assertTrue("Should include Android 15", state.releases.any { it.versionName == "15" })
    assertTrue("Hardware list should not be empty", state.hardwareDevices.isNotEmpty())
    assertTrue("Architecture topics should not be empty", state.architectureTopics.isNotEmpty())
  }

  @Test
  fun `verify counterparts graveyard and gradle loaded properly`() {
    val viewModel = HistoryViewModel()
    val state = viewModel.uiState.value

    assertTrue("Counterparts should not be empty", state.counterpartComparisons.isNotEmpty())
    assertTrue("Should compare notifications", state.counterpartComparisons.any { it.id == "notifications" })

    assertTrue("Graveyard features should not be empty", state.graveyardFeatures.isNotEmpty())
    assertTrue("Should include Android Beam in graveyard", state.graveyardFeatures.any { it.id == "android_beam" })

    assertTrue("Gradle milestones should not be empty", state.gradleMilestones.isNotEmpty())
    assertTrue("Gradle topics should not be empty", state.gradleTopics.isNotEmpty())
    assertTrue("Should include Gradle compilation pipeline", state.gradleTopics.any { it.id == "pipeline" })
  }

  @Test
  fun `verify bookmark toggle and tabs`() {
    val viewModel = HistoryViewModel()
    val firstReleaseId = viewModel.uiState.value.releases.first().id

    assertFalse(viewModel.uiState.value.bookmarkedReleaseIds.contains(firstReleaseId))
    viewModel.toggleBookmark(firstReleaseId)
    assertTrue(viewModel.uiState.value.bookmarkedReleaseIds.contains(firstReleaseId))

    viewModel.selectTab(AppTab.HARDWARE)
    assertEquals(AppTab.HARDWARE, viewModel.uiState.value.currentTab)
  }

  @Test
  fun `verify quiz scoring flow`() {
    val viewModel = HistoryViewModel()
    val initialScore = viewModel.uiState.value.quizScore
    val firstQuestion = viewModel.uiState.value.quizQuestions.first()

    viewModel.selectQuizAnswer(firstQuestion.correctIndex)
    assertEquals(initialScore + 1, viewModel.uiState.value.quizScore)
    assertTrue(viewModel.uiState.value.isQuestionAnswered)
  }
}
