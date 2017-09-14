apply plugin: 'com.android.application'

android {

    //签名
    
    signingConfigs {
    
        config {
        
            keyAlias 'joe'
            
            keyPassword '123456'
            
            storeFile file('key.jks')//相对路径
            
            storePassword '123456'
            
        }
        
    }
    

    compileSdkVersion 25
    buildToolsVersion "25.0.3"


    defaultConfig {
        applicationId "com.chinaums.variant"
        minSdkVersion 16
        targetSdkVersion 25
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {

        debug {
            minifyEnabled false
            debuggable true
        }

        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
            signingConfig signingConfigs.config  // 配置release包的签名
            debuggable false
        }
    }
    //利用productFlavors 构建三个不同的版本，product ,uat ,uduat 
    //三个版本分别调用不同的API_URL,不同的app_name
    //此时需要把主工程里面的app_name注释掉，否则资源会冲突 <!-- <string name="app_name">app</string>-->
    //代码中调用 API_URL  ，使用 BuildConfig.API_URL 
    productFlavors {
        product {
            applicationId 'product.com.chinaums.variant'
            buildConfigField 'String', 'API_URL', '"http://www.baidu.com"'
            resValue "string", "app_name", "app"
            versionName '1.0-product'
        }
        uat {
            applicationId 'uat.com.chinaums.variant'
            buildConfigField 'String', 'API_URL', '"http://www.google.com"'
            resValue "string", "app_name", "app_us"
            versionName '1.0-uat'
        }
        nduat {
            applicationId 'uduat.com.chinaums.variant'
            buildConfigField 'String', 'API_URL', '"http://www.nanfei.com"'
            resValue "string", "app_name", "app_za"
            versionName '1.0-uduat'
        }
    }
}

dependencies {

    compile fileTree(dir: 'libs', include: ['*.jar'])
    
    compile 'com.android.support:appcompat-v7:25.3.1'
    
    compile 'com.android.support.constraint:constraint-layout:1.0.2'
    
}
