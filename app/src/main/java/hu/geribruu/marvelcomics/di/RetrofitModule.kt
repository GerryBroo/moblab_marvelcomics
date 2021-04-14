package hu.geribruu.marvelcomics.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.geribruu.marvelcomics.network.CharacterApi
import hu.geribruu.marvelcomics.network.NetworkInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor() : HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(NetworkInterceptor())
                .addInterceptor(interceptor)
                .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client : OkHttpClient) : Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://gateway.marvel.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
    }

    @Singleton
    @Provides
    fun provideCharacterApiService(retrofit : Retrofit) : CharacterApi {
        return retrofit.create(CharacterApi::class.java)
    }
}