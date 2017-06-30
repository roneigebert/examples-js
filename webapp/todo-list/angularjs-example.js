var app = angular.module("todoApp", [])

app.service("todoListService", function($http) {
    this.all = function(){
        return $http.get( '/api/todo' )
    }
    this.get = function( id ){
        return $http.get( '/api/todo/' + id )
    }
    this.remove = function( id ){
        return $http.delete( '/api/todo/' + id )
    }
    this.save = function( model ){
        var httpMethod = model.id ? $http.put : $http.post
        return httpMethod( '/api/todo', model )
    }
})

app.controller("todoListController", function($scope, todoListService) {

    $scope.initForm = function(model){
        $scope.formModel = model || {}
    }

    $scope.loadTodoList = function(){
        todoListService.all().then(function(response){
            $scope.todoModels = response.data
        })
    }

    $scope.submitForm = function(){
        todoListService.save( $scope.formModel ).then(function(response){
            $scope.loadTodoList()
            $scope.initForm()
        })
    }

    $scope.editModel = function(model){
        todoListService.get(model.id).then(function(response){
            $scope.initForm( response.data )
        })
    }

    $scope.removeModel = function(model){
        if ( confirm("You want confirm deletion?") ){
            todoListService.remove(model.id).then(function(){
                $scope.loadTodoList()
            })
        }
    }

    $scope.initForm()
    $scope.loadTodoList()

})