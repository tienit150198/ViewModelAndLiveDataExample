# ViewModelAndLiveDataExample

----
## [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)

> L� m?t class du?c thi?t k? d? luu tr? v� qu?n l� d? li?u trong m?t lifecycler ri�ng, b?o to�n d? li?u k? c? khi xoay m�n h�nh.

<img src="https://imgur.com/yCKwbDt">

Th�ng thu?ng, khi xoay m�n h�nh, activity s? destroy v� create l?i. Khi d� d? li?u to�n b? s? b? bi?n m?t.

�? kh?c ph?c di?u n�y, ch�ng ta c� th? s? d?ng h�m `onSaveInstanceState()` ho?c ViewModel c?a android.


### Config
Th�m thu vi?n sau:

```ruby
// ViewModel

    implementation "androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version"
    // LiveData
    implementation "androidx.lifecycle:lifecycle-livedata:$lifecycle_version"
    // Lifecycles only (without ViewModel or LiveData)
    implementation "androidx.lifecycle:lifecycle-runtime:$lifecycle_version"
    // Annotation processor
    annotationProcessor "androidx.lifecycle:lifecycle-compiler:$lifecycle_version"
    // Saved state module for ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version"
    implementation "android.arch.lifecycle:extensions:$lifecycle_version"
```


----
## usage
1. Write markdown text in this textarea.
2. Click 'HTML Preview' button.

----
## markdown quick reference
# headers

*emphasis*

**strong**

* list

>block quote

    code (4 spaces indent)
[links](https://wikipedia.org)

----
## changelog
* 17-Feb-2013 re-design

----
## thanks
* [markdown-js](https://github.com/evilstreak/markdown-js)
