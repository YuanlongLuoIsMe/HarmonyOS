package com.bmit.app.smart.refuel.util;

import ohos.agp.render.*;
import ohos.agp.utils.RectFloat;
import ohos.app.Context;
import ohos.global.resource.NotExistException;
import ohos.media.image.ImageSource;
import ohos.media.image.PixelMap;
import ohos.media.image.common.PixelFormat;
import ohos.media.image.common.Size;

import java.io.IOException;
import java.io.InputStream;

public class PixelMapShapeUtil {
    public static PixelMap makeCircle(Context context, int resourceId) {
        //从资源文件加载PixelMap
        PixelMap originMap = null;
        InputStream inputStream = null;
        try {
            inputStream = context.getResourceManager().getResource(resourceId);
            ImageSource.SourceOptions srcOpts = new ImageSource.SourceOptions();
            srcOpts.formatHint = "image/png";
            ImageSource imageSource = ImageSource.create(inputStream, srcOpts);
            // 设置图片参数
            ImageSource.DecodingOptions decodingOptions = new ImageSource.DecodingOptions();
            originMap = imageSource.createPixelmap(decodingOptions);
        } catch (NotExistException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //获取原图片的大小
        Size originSize = originMap.getImageInfo().size;
        PixelMap.InitializationOptions options = new PixelMap.InitializationOptions();
        options.size = new Size(originSize.width, originSize.height);
        options.pixelFormat = PixelFormat.ARGB_8888;
        options.editable = true;
        //创建结果PixelMap
        PixelMap circlePixelMap = PixelMap.create(options);
        Canvas canvas = new Canvas();
        //将结果PixelMap作为画布背景
        Texture texture = new Texture(circlePixelMap);
        canvas.setTexture(texture);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        PixelMapHolder pixelMapHolder = new PixelMapHolder(PixelMap.create(originMap, options));
        PixelMapShader shader = new PixelMapShader(pixelMapHolder, Shader.TileMode.CLAMP_TILEMODE, Shader.TileMode.CLAMP_TILEMODE);
        paint.setShader(shader, Paint.ShaderType.PIXELMAP_SHADER);
        //生成圆形PixelMap
        canvas.drawCircle(originSize.width * 1.0f / 2, originSize.height * 1.0f / 2, originSize.width * 1.0f / 2, paint);
        return circlePixelMap;
    }

    public static PixelMap makeCircle(Context context, PixelMap originMap) {
        //获取原图片的大小
        Size originSize = originMap.getImageInfo().size;
        PixelMap.InitializationOptions options = new PixelMap.InitializationOptions();
        options.size = new Size(originSize.width, originSize.height);
        options.pixelFormat = PixelFormat.ARGB_8888;
        options.editable = true;
        //创建结果PixelMap
        PixelMap circlePixelMap = PixelMap.create(options);
        Canvas canvas = new Canvas();
        //将结果PixelMap作为画布背景
        Texture texture = new Texture(circlePixelMap);
        canvas.setTexture(texture);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        PixelMapHolder pixelMapHolder = new PixelMapHolder(PixelMap.create(originMap, options));
        PixelMapShader shader = new PixelMapShader(pixelMapHolder, Shader.TileMode.CLAMP_TILEMODE, Shader.TileMode.CLAMP_TILEMODE);
        paint.setShader(shader, Paint.ShaderType.PIXELMAP_SHADER);
        //生成圆形PixelMap
        canvas.drawCircle(originSize.width * 1.0f / 2, originSize.height * 1.0f / 2, originSize.width * 1.0f / 2, paint);
        return circlePixelMap;
    }

    public static PixelMap makeRect(Context context, int resourceId, float radiusX, float radiusY) {
        //从资源文件加载PixelMap
        PixelMap originMap = null;
        InputStream inputStream = null;
        try {
            inputStream = context.getResourceManager().getResource(resourceId);
            ImageSource.SourceOptions srcOpts = new ImageSource.SourceOptions();
            srcOpts.formatHint = "image/png";
            ImageSource imageSource = ImageSource.create(inputStream, srcOpts);
            // 设置图片参数
            ImageSource.DecodingOptions decodingOptions = new ImageSource.DecodingOptions();
            originMap = imageSource.createPixelmap(decodingOptions);
        } catch (NotExistException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //获取原图片的大小
        Size originSize = originMap.getImageInfo().size;
        PixelMap.InitializationOptions options = new PixelMap.InitializationOptions();
        options.size = new Size(originSize.width, originSize.height);
        options.pixelFormat = PixelFormat.ARGB_8888;
        options.editable = true;
        //创建结果PixelMap
        PixelMap circlePixelMap = PixelMap.create(options);
        Canvas canvas = new Canvas();
        //将结果PixelMap作为画布背景
        Texture texture = new Texture(circlePixelMap);
        canvas.setTexture(texture);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        PixelMapHolder pixelMapHolder = new PixelMapHolder(PixelMap.create(originMap, options));
        PixelMapShader shader = new PixelMapShader(pixelMapHolder, Shader.TileMode.CLAMP_TILEMODE, Shader.TileMode.CLAMP_TILEMODE);
        paint.setShader(shader, Paint.ShaderType.PIXELMAP_SHADER);
        //绘制圆角
        RectFloat rect = new RectFloat(0, 0, originSize.width, originSize.height);
        canvas.drawRoundRect(rect, radiusX, radiusY, paint);
        return circlePixelMap;
    }

    public static PixelMap makeRect(Context context, PixelMap originMap, float radiusX, float radiusY) {
        //获取原图片的大小
        Size originSize = originMap.getImageInfo().size;
        PixelMap.InitializationOptions options = new PixelMap.InitializationOptions();
        options.size = new Size(originSize.width, originSize.height);
        options.pixelFormat = PixelFormat.ARGB_8888;
        options.editable = true;
        //创建结果PixelMap
        PixelMap circlePixelMap = PixelMap.create(options);
        Canvas canvas = new Canvas();
        //将结果PixelMap作为画布背景
        Texture texture = new Texture(circlePixelMap);
        canvas.setTexture(texture);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        PixelMapHolder pixelMapHolder = new PixelMapHolder(PixelMap.create(originMap, options));
        PixelMapShader shader = new PixelMapShader(pixelMapHolder, Shader.TileMode.CLAMP_TILEMODE, Shader.TileMode.CLAMP_TILEMODE);
        paint.setShader(shader, Paint.ShaderType.PIXELMAP_SHADER);
        //绘制圆角
        RectFloat rect = new RectFloat(0, 0, originSize.width, originSize.height);
        canvas.drawRoundRect(rect, radiusX, radiusY, paint);
        return circlePixelMap;
    }
}
