var app = angular.module('myApp', []);

app.controller('myCtrl', function($scope, $http) {

    $http.get("/receipt/getAllReceiptCode")
        .then(function(response) {

            $scope.receipts = response.data.data;
            $scope.receiptCodeSelected =  $scope.receipts[0];
            console.log($scope.receipts)

        });

    $http.get("/operation/getAllOperation")
        .then(function(response) {

            $scope.operation = response.data.data;
            console.log($scope.operation)
        });

    $scope.deledteOperation = function(obj) {
        $http.delete('/operation/delete/' + obj.operationCode)
            .success(function (data, status, headers) {
                $scope.ServerResponse = data;
                console.log(data);
                location.reload();
            })
            .error(function (data, status, header, config) {

                console.log(data)
            });
    };


    $scope.submit = function() {

        console.log($scope.code);
        console.log($scope.desc);
        console.log($scope.price);
        console.log($scope.wage);
        console.log($scope.charge);
        console.log($scope.receiptCodeSelected.receiptCode);


        var data = {
            "operationCode" : $scope.code,
            "operationDesc" : $scope.desc,
            "price" : $scope.price,
            "defaultWage" : $scope.wage,
            "defaultDLT" : $scope.charge,
            "receiptCode" : $scope.receiptCodeSelected.receiptCode
        };


        $http.post("/operation/save", data)
            .success(function (data, status, headers){
                console.log(data);
                location.reload();
            })
            .error(function (data, status, header, config) {
                console.log(data)
            });
    };

});