package com.example.neurecare.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.neurecare.R
import com.example.neurecare.data.datadummy.dummyOnBoarding
import com.example.neurecare.ui.navigation.Routes
import com.example.neurecare.ui.theme.NeurecareTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@SuppressLint("ResourceType", "UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalPagerApi::class, ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(navController: NavController) {
    val items = dummyOnBoarding
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState()
    val (selectedPage, setSelectedPage) = remember {
        mutableStateOf(0)
    }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            setSelectedPage(page)
        }
    }

    Scaffold {
        Row {
            TopSection(
                onSkipClick = {
                    if (pagerState.currentPage + 1 < items.size) scope.launch {
                        pagerState.scrollToPage(items.size - 1)
                    }
                }
            )
        }
        Column {
            HorizontalPager(
                count = dummyOnBoarding.size,
                state = pagerState,
                modifier = Modifier.weight(0.6f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                ) {
//                    LottieAnimation(
//                        composition,
//                        /// looping the animation
//                        iterations = LottieConstants.IterateForever,
//                        modifier = Modifier.weight(1f)
//                    )
                    Image(painter = painterResource(id = dummyOnBoarding[it].icon), contentDescription = null)
                    Text(
                        dummyOnBoarding[it].title,
                        fontSize = 24.sp,
                        color = colorResource(id = R.color.brown),
                        textAlign = TextAlign.Center
                    )
                    Box(modifier = Modifier.height(24.dp))
                    Text(
                        dummyOnBoarding[it].description,
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.teal_700),
                        textAlign = TextAlign.Center,
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                for (i in dummyOnBoarding.indices) {
                    Box(
                        modifier = Modifier
                            .padding(end = if (i == dummyOnBoarding.size - 1) 0.dp else 5.dp)
                            .width(if (i == selectedPage) 20.dp else 20.dp)
                            .height(4.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(
                                if (i == selectedPage) colorResource(id = R.color.orange) else colorResource(
                                    id = R.color.cream
                                )
                            )
                    )

                }
            }

            // only show if not last page
            if (selectedPage != dummyOnBoarding.size - 1) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Button(
                        onClick = {
                            scope.launch {
                                /// iterate to next screen
                                val nextPage = selectedPage + 1
                                pagerState.animateScrollToPage(nextPage)
                            }
                        },
                        modifier = Modifier
                            .height(59.dp)
                            .align(Alignment.CenterHorizontally)
                            .width(300.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.brown)
                        )

                    ) {
                        Text(text = "Selanjutnya", fontSize = 16.sp, color = Color.White)
                    }
                }
            }

            /// show only in last page
            if (selectedPage == dummyOnBoarding.size - 1) {
                Button(
                    onClick = {
                        navController.navigate(Routes.Login.route) {
                            popUpTo(Routes.OnBoard.route){
                                inclusive = true
                            }
                        }
                    },
                    modifier = Modifier
                        .padding(12.dp)
                        .width(300.dp)
                        .align(Alignment.CenterHorizontally)
                        .height(56.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.brown)
                    )

                ) {
                    Text(text = "Get Started", fontSize = 16.sp, color = Color.White)
                }
            }
        }
    }
}

@Composable
fun TopSection(onSkipClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        // Skip Button
        TextButton(
            onClick = onSkipClick,
            modifier = Modifier.align(Alignment.CenterEnd),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(text = "Skip", color = colorResource(id = R.color.brown), fontSize = 14.sp)
        }
    }
}

@Preview
@Composable
fun GetStartedScreenPreview() {
    NeurecareTheme() {
        OnBoardingScreen(navController = rememberNavController())
    }

}