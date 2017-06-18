<!DOCTYPE html>
<html ng-app="atms">
<head lang="en">
    <meta charset="UTF-8">
    <title>Find your Dutch ATM</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="shortcut icon" href="resources/img/favicon-96x96.png" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="resources/css/style.css">
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
    <script src="resources/js/index.js"></script>
</head>
<body class="container-fluid" ng-controller="mainController">
    <h1>ING locator for Dutch ATM's </h1>
	<table width=100%><td align="left">
    <table>
    <tr><td>
    <form ng-submit="searchAtms()">
        <div class="form-group"><div class="input-group">
                <table>
                <tr>
                	<td>Find your ATM at CITY : </td>
                	<td><input type="text" class="form-control" ng-model="filterValue" required /></td>
                	<td>&nbsp;</td>
                	<td><span class="input-group-btn">
                    	<input class="btn btn-default" type="submit" value="Find ATMs"/>
                	</span></td>
                	<td>&nbsp;</td>
                </tr>
                </table>
         </div></div>
    </form>
    </td>
    <td>
        <div class="form-group"><div class="input-group">
        <span class="input-group-btn">
           	<input class="btn btn-default" type="button" value="All ATMs" ng-click="clearFilter()"/>
        </span>
        </div></div>
        </td>
    </tr>
    </table></td>
        <td align="right"><div class="form-group"><div class="input-group">
        <span class="input-group-btn">
           	<input class="btn btn-default" type="button" value="Log out" onclick="javascript: location.href='/atm-mvc-rest/login?logout'"/>
        </span>
        </div>
        </td>
    </table>
    <table class="table table-bordered table-condensed">
        <thead>
            <tr>
                <th>Type</th>  
                <th>House Number</th>
                <th>Street</th>
                <th>City</th>
                <th>Postal Code</th>
                <th>Get location</th>
            </tr>
        </thead>
        <tbody>
            <tr ng-repeat="atm in atms"> 
                <td>{{atm.type}}</td>
                <td>{{atm.address.housenumber}}</td>
                <td>{{atm.address.street}}</td>
                <td>{{atm.address.city}}</td>
                <td>{{atm.address.postalcode}}</td>
                <td><input class="btn btn-default" type="button" value="get Maps" ng-click="getLocationMap(atm.type,atm.address.street,atm.address.housenumber,atm.address.postalcode,atm.address.city,atm.address.geoLocation.lat,atm.address.geoLocation.lng)"/></td>
            </tr>
        </tbody>
    </table>
    <div class="loading-modal"><!-- Place at bottom of page --></div>
</body>
</html>
