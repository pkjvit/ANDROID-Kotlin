package com.pkj.wow.androidkotlin.kotlin.flow

/*
class MyViewModel(...) : ViewModel() {
    val result = userId.mapLatest { newUserId ->
        repository.observeItem(newUserId)
    }.stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000),
        initialValue = Result.Loading
    )
}
// Activity
onCreateView(...) {
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.lifecycle.repeatOnLifecycle(STARTED) {
            myViewModel.myUiState.collect { ... }
        }
    }
}

*/
