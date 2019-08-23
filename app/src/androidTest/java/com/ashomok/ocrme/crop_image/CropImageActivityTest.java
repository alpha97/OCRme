package com.ashomok.ocrme.crop_image;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.test.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import java.io.File;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.ashomok.ocrme.utils.FilesProvider.getTestImages;
import static com.ashomok.ocrme.utils.LogUtil.DEV_TAG;

/**
 * Created by iuliia on 11/28/17.
 */
public class CropImageActivityTest {
    private static final String TAG = DEV_TAG + CropImageActivityTest.class.getSimpleName();

    @Rule
    public ActivityTestRule<CropImageActivity> mActivityRule = new ActivityTestRule<>(
            CropImageActivity.class, true, false);


    @Test
    public void testCrop() throws InterruptedException {
        String path = getTestImages().get(1);
        launchActivityWithPath(Uri.fromFile(new File(path)));
        Thread.sleep(1000);
    }

//    @Test
//    public void backgroundSettedProperly() throws InterruptedException {
//        String path = getTestImages().get(0);
//        launchActivityWithPath(Uri.fromFile(new File(path)));
//
//        onView(withId(R.id.image)).check(matches(isDisplayed()));
//        onView(withId(R.id.image)).check(matches(hasDrawable()));
//        Thread.sleep(10000); //waiting for ocr finished
//        onView(withId(R.id.source_image)).check(matches(hasDrawable()));
//        onView(withId(R.id.source_image)).check(matches(isDisplayed()));
//    }

    private void launchActivityWithPath(Uri uri) {
        Context targetContext = InstrumentationRegistry.getInstrumentation()
                .getTargetContext();
        Intent intent = new Intent(targetContext, CropImageActivity.class);
        intent.putExtra(CropImageActivity.EXTRA_IMAGE_URI, uri);
        mActivityRule.launchActivity(intent);
    }
}