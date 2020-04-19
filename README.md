# ViewModelAndLiveDataExample

----
## [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)

> Là một class được thiết kế để lưu trữ và quản lý dữ liệu trong một lifecycler riêng, bảo toàn dữ liệu kể cả khi xoay màn hình.


![yCKwbDt](https://user-images.githubusercontent.com/52131412/79693762-38a57580-829f-11ea-99a8-4148a46f532d.png)

Thông thường, khi xoay màn hình, `Activity` sẽ `destroy` và `create` lại. Khi đó dữ liệu hiện tại sẽ bị biến mất.

Để khắc phục điều này, chúng ta có thể sử dụng hàm `onSaveInstanceState()` hoặc ViewModel của android.


### Config
Thêm thư viện sau:

```ruby
def lifecycle_version = "2.2.0"

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

### Code

1. Tạo Model

Để sử dụng `ViewModel` thì ta sẽ **extends class** `AndroidViewModel`

```java
public class CountNumberViewModel extends AndroidViewModel {
// do somethings
}
```
2. Để request một ViewModel, chúng ta không nên sử dụng câu lệnh new, mà chúng ta nên sử dụng câu lệnh of của [ViewModelProviders](https://developer.android.com/reference/android/arch/lifecycle/ViewModelProviders#of(android.support.v4.app.Fragment)) `ViewModelProviders.of(<Your UI controller>).get(<Your ViewModel>.class)`

Example

```java
CountNumberViewModel mViewModel = ViewModelProviders.of(this).get(CountNumberViewModel.class);
```

# [LiveData](https://developer.android.com/reference/android/arch/lifecycle/LiveData.html)


>LiveData is a data holder class that can be observed within a given lifecycle. This means that an Observer can be added in a pair with a LifecycleOwner, and this observer will be notified about modifications of the wrapped data only if the paired LifecycleOwner is in active state. LifecycleOwner is considered as active, if its state is STARTED or RESUMED. An observer added via observeForever(Observer) is considered as always active and thus will be always notified about modifications. For those observers, you should manually call removeObserver(Observer). 

Theo android, LiveData là một class data holder, nó sẽ quan sát sự thay đổi của data trong một vòng đời nhất định.

* `LiveData` được giới hạn bởi `LifecyclerOwner`, cụ thể là lúc mà `LifecyclerOwner` được coi là `Active` ( `STATED` và `RESUMED` )
* Để quan sát sự thay đổi của data thì ta sử dụng cú pháp `Observer` hoặc `observeForever`.
* Khi sử dụng `observeForever` sẽ được hiểu là luôn luôn trong trạng thái `Active`. Khi sử dụng `observeForever` để hủy trạng thái `Active` của `LifecyclerOwner`, chúng ta sử dụng câu lệnh `removeObserver`
* Để quan sát xem đang ở trạng thái `Active` hay không, ta sử dụng hàm `onActive()` hoặc `onInactive()`.
* Để thao tác với `LiveData` trong `Model`, chúng ta sử dụng `postValue` hoặc `setValue`. Trong đó `postValue` nên sử dụng trong `Worker Thread`.

### Chú ý:
1. Các method `postValue`, `setValue`, `onActive` hoặc `onInactive` là `protected`. Để sử dụng `postValue` hoặc `setValue` ta sử dụng `MutableLiveData` thay vì `LiveData`.

2. Nên lắng nghe `LiveData` ở `OnCreate` để tránh gọi nhiều lần thông qua `onResume`.

### Mở rộng

#### Transform LiveData
Chúng ta mỗi thay đổi giá trị của data lưu trữ trong `LiveData object` trước khi gửi đi tới các `observer`, hoặc chúng ta muốn tạo ra một `LiveData` khác so với `LiveData` ban đầu chẳng hạn, lúc này là lúc chúng ta sử dụng `Transformations`.

`Transformations` cung cấp cho chúng ta 2 method vô cùng tiện lợi.

##### 1. Transformations.map()
Chúng ta sử dụng method này trên main thread để có thể chuyển đổi `LiveData` theo ý muốn của mình Giả sử chúng ta có 1 `LiveData` chứa một user, và chúng ta muốn hiển thị tên của user đó lên màn hình chúng ta có thể làm như sau

```java
LiveData<User> userLiveData = ...;
LiveData<String> userName = Transformations.map(userLiveData, user -> {
    user.name + " " + user.lastName
});
```

#### 2. Transformations.switchMap()
`switchMap()` dùng cũng tương tự như `map()` tuy nhiên `switchMap()` bắt buộc phải trả về một `LiveData object`.

```java
private LiveData<User> getUser(String id) {
  ...;
}

LiveData<String> userId = ...;
LiveData<User> user = Transformations.switchMap(userId, id -> getUser(id) );
```

# Tham khảo
https://viblo.asia/p/android-architecture-components-viewmodel-xu-ly-configuration-changes-chua-bao-gio-don-gian-den-the-ByEZk3A4ZQ0

https://viblo.asia/p/android-livedata-oOVlY1Yrl8W

https://developer.android.com/topic/libraries/architecture/viewmodel

https://developer.android.com/reference/android/arch/lifecycle/LiveData.html

https://developer.android.com/topic/libraries/view-binding
