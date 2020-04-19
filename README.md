# ViewModelAndLiveDataExample

----
## [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)

> Là một class được thiết kế để lưu trữ và quản lý dữ liệu trong một lifecycler riêng, bảo toàn dữ liệu kể cả khi xoay màn hình.

<img src="https://imgur.com/yCKwbDt">

Thông thường, khi xoay màn hình, activity sẽ destroy và create lại. Khi đó dữ liệu toàn bộ sẽ bị biến mất.

Để khắc phục điều này, chúng ta có thể sử dụng hàm `onSaveInstanceState()` hoặc ViewModel của android.


### Config
Thêm thư viện sau:

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
