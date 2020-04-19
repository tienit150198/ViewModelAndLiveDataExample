# ViewModelAndLiveDataExample

----
## [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)

> Là m?t class du?c thi?t k? d? luu tr? và qu?n lý d? li?u trong m?t lifecycler riêng, b?o toàn d? li?u k? c? khi xoay màn hình.

<img src="https://imgur.com/yCKwbDt">

Thông thu?ng, khi xoay màn hình, activity s? destroy và create l?i. Khi dó d? li?u toàn b? s? b? bi?n m?t.

Ð? kh?c ph?c di?u này, chúng ta có th? s? d?ng hàm `onSaveInstanceState()` ho?c ViewModel c?a android.


### Config
Thêm thu vi?n sau:

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
