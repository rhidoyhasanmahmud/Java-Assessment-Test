
# API Details

> Status API

1. Status > Create
```text
METHOD       :  Post
URI          :  /api/pmt/status
Req. Ex.     : {base}/api/pmt/status
Req. Header  : createdBy   ,  createdByEmp
```
```text
Request Body Sample
{
   "name"  : "Completed",
   "active": true
}
```

2. Status > Get All Active
```text
METHOD     : Get
URI        : /api/pmt/status/getAll/active?page=0&pageSize=100
Req. Ex.   : {base}/api/pmt/status/getAll/active?page=0&pageSize=100
```
3. Status > Get All Inactive
```text
METHOD     : Get
URI        : /api/pmt/status/getAll/inactive?page=0&pageSize=100
Req. Ex.   : {base}/api/pmt/status/getAll/inactive?page=0&pageSize=100
```
4. Status > Get By ID
```text
METHOD     : GET
URI        : /api/pmt/status/get/{id}
Req. Ex.   : {base}/api/pmt/status/get/1
```
5. Status > Update
```text
METHOD     : PUT
URI        : /api/pmt
Req. Ex.   : {base}/api/pmt
Req. Header: updatedBy   ,  updatedByEmp
```
6. Status > Get Dropdown Data
```text
METHOD      : Get
URI         : /api/pmt/status/getAll/active/dropdown
Req. Ex.    : {base}/api/pmt/status/getAll/active/dropdown
```
7. Status > Exists by name
```text
METHOD      : Get
URI         : /api/pmt/status/exists/byName?name=name
Req. Ex.    : {base/api/pmt/status/exists/byName?name=name
```
> Project API

1. Project > Create
```text
METHOD       :  Post
URI          :  /api/pmt/project
Req. Ex.     : {base}/api/pmt/project
Req. Header  : createdBy   ,  createdByEmp
```
```text
Request Body Sample
{
   "name"        : "Project 1",
   "description" : "Description"
   "statusId"    : 1
   "active"      : true
}
```

2. Project > Get All Active
```text
METHOD     : Get
URI        : /api/pmt/project/getAll/active?page=0&pageSize=100
Req. Ex.   : {base}/api/pmt/project/getAll/active?page=0&pageSize=100
```
3. Project > Get All Inactive
```text
METHOD     : Get
URI        : /api/pmt/project/getAll/inactive?page=0&pageSize=100
Req. Ex.   : {base}/api/pmt/project/getAll/inactive?page=0&pageSize=100
```
4. Project > Get By ID
```text
METHOD     : GET
URI        : /api/pmt/project/get/{id}
Req. Ex.   : {base}/api/pmt/project/get/1
```
5. Project > Update
```text
METHOD     : PUT
URI        : /api/pmt
Req. Ex.   : {base}/api/pmt
Req. Header: updatedBy   ,  updatedByEmp
```
6. Project > Get Dropdown Data
```text
METHOD      : Get
URI         : /api/pmt/project/getAll/active/dropdown
Req. Ex.    : {base}/api/pmt/project/getAll/active/dropdown
```
7. Project > Exists by name
```text
METHOD      : Get
URI         : /api/pmt/project/exists/byName?name=name
Req. Ex.    : {base/api/pmt/project/exists/byName?name=name
```
> Task API

1. Task > Create
```text
METHOD       :  Post
URI          :  /api/pmt/task
Req. Ex.     : {base}/api/pmt/task
Req. Header  : createdBy   ,  createdByEmp
```
```text
Request Body Sample
{
   "name"        : "Task 1",
   "projectId"   : 1
   "statusId"    : 1
   "active"      : true
}
```

2. Task > Get All Active
```text
METHOD     : Get
URI        : /api/pmt/task/getAll/active?page=0&pageSize=100
Req. Ex.   : {base}/api/pmt/task/getAll/active?page=0&pageSize=100
```
3. Task > Get All Inactive
```text
METHOD     : Get
URI        : /api/pmt/task/getAll/inactive?page=0&pageSize=100
Req. Ex.   : {base}/api/pmt/task/getAll/inactive?page=0&pageSize=100
```
4. Task > Get By ID
```text
METHOD     : GET
URI        : /api/pmt/task/get/{id}
Req. Ex.   : {base}/api/pmt/task/get/1
```
5. Task > Update
```text
METHOD     : PUT
URI        : /api/pmt
Req. Ex.   : {base}/api/pmt
Req. Header: updatedBy   ,  updatedByEmp
```
6. Task > Exists by name
```text
METHOD      : Get
URI         : /api/pmt/task/exists/byName?name=name
Req. Ex.    : {base/api/pmt/task/exists/byName?name=name
``` 




