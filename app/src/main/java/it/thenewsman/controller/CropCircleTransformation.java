package it.thenewsman.controller; /**
 *
 * This class is part of glide-transformations library
 * (from https://github.com/wasabeef/glide-transformations/blob/
 * master/transformations/src/main/java/jp/wasabeef/glide/
 * transformations/CropCircleTransformation.java)
 *
 * Copyright (C) 2015 Wasabeef
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

public class CropCircleTransformation implements Transformation<Bitmap> {

  private BitmapPool mBitmapPool;
  private static final String TAG = "CropCircleTransformation()";

  public CropCircleTransformation(Context context) {
    this(Glide.get(context).getBitmapPool());
  }

  public CropCircleTransformation(BitmapPool pool) {
    this.mBitmapPool = pool;
  }

  @Override
  public Resource<Bitmap> transform(Resource<Bitmap> resource, int outWidth, int outHeight) {
    Bitmap source = resource.get();
    int size = Math.min(source.getWidth(), source.getHeight());

    Bitmap bitmap = mBitmapPool.get(size, size, Bitmap.Config.ARGB_8888);
    if (bitmap == null) {
      bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
    }

    Canvas canvas = new Canvas(bitmap);
    Paint paint = new Paint();
    float r = size / 2f;

    canvas.drawCircle(r, r, r, paint);

    return BitmapResource.obtain(bitmap, mBitmapPool);
  }

  @Override public String getId() {
    return TAG;
  }
}