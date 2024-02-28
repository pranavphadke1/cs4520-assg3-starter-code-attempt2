https://github.com/pranavphadke1/cs4520-assg3-starter-code-attempt2

Project Overview:
This project implements a calculator with 4 simple functions (add, subtract, multiply, divide). The project implements 
this calculator through two architectures. One way is through MVP and the other is through MVVM.

MVP
The MVP method uses a View called MVPFragment.kt, a model called Model.kt, and a presenter called MVPPresenter.kt. 
Each one of these implements a corresponding interface found in MVPContract.
The Presenter holds a reference to the Model and the View and uses event listeners setup in the View to receive data and
forwards that data to the model.

MVVM
The MVVM method uses a View called MVVMFragment.kt, the same model as the MVP (Model.kt), and a ViewModel called MVVMViewModel.kt.
In MVVM, the viewmodel acts as a bridge between the View and the Model and doesn't hold references to the view. The ViewModel contains
LiveData (result and displayErrorMessage). The View has a reference to the ViewModel and access its LiveData to present an updated
UI to the user.

Note that both of these implementations use the same model to reduce repeated code - the only difference is that the MVVM implementation
stores the two numbers in the model (MVP doesn't need to store since the Presenter has access to the View and can send the model the current
values by accessing it's View reference).
