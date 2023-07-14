<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html>

    <html lang="en">
    <!--begin::Head-->

    <head>
        <meta charset="utf-8" />
        <title>Sign In </title>
        <meta name="description" content="Singin page example" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <link rel="canonical" href="https://keenthemes.com" />
 <!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath}/app-assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/app-assets/css/sb-admin-2.min.css" rel="stylesheet">
      
      <style>
    .background-radial-gradient {
      background-color: hsl(218, 41%, 15%);
      background-image: radial-gradient(650px circle at 0% 0%,
          hsl(218, 41%, 35%) 15%,
          hsl(218, 41%, 30%) 35%,
          hsl(218, 41%, 20%) 75%,
          hsl(218, 41%, 19%) 80%,
          transparent 100%),
        radial-gradient(1250px circle at 100% 100%,
          hsl(218, 41%, 45%) 15%,
          hsl(218, 41%, 30%) 35%,
          hsl(218, 41%, 20%) 75%,
          hsl(218, 41%, 19%) 80%,
          transparent 100%);
    }

    #radius-shape-1 {
      height: 220px;
      width: 220px;
      top: -60px;
      left: -130px;
      background: radial-gradient(#44006b, #ad1fff);
      overflow: hidden;
    }

    #radius-shape-2 {
      border-radius: 38% 62% 63% 37% / 70% 33% 67% 30%;
      bottom: -60px;
      right: -110px;
      width: 300px;
      height: 300px;
      background: radial-gradient(#44006b, #ad1fff);
      overflow: hidden;
    }

    .bg-glass {
      background-color: hsla(0, 0%, 100%, 0.9) !important;
      backdrop-filter: saturate(200%) blur(25px);
    }
  </style>
    </head>
    <!--end::Head-->

    <!--begin::Body-->

   <body class="background-radial-gradient overflow-hidden">
   
   <!-- Section: Design Block -->
<!-- Section: Design Block -->
  <div class="container" style="margin-top: 7.5rem !important">
    <div class="row gx-lg-5  d-flex justify-content-center  mb-5">

      <div class="col-lg-6 col-sm-5 col-md-6 mb-5 mb-lg-0 position-relative">
        <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
        <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

        <div class="card bg-glass">
        <div class="text-center mt-5">
            <img alt="The Shoppe" src="${pageContext.request.contextPath}/app-assets/img/Shopee-Login-page.png">
        </div>
          <div class="card-body px-4 py-5 px-md-5">
            <form  class="user" id="loginValidate" name='f' method='POST' action="login">
              <!-- 2 column grid layout with text inputs for the first and last names -->
              <div class="row">
                <div class="col-md-12 mb-4">
                  <div class="form-outline">
                  <label class="form-label" for="form3Example1">User name</label>
                    <input type="text" class="form-control" id="username" name="username" autocomplete="off" required />
                  </div>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
              </div>
              <!-- Password input -->
              <div class="form-outline mb-4">
              	<label class="form-label" for="form3Example4">Password</label>
                <input type="password" class="form-control" name="password" id="password" autocomplete="off" required  />
              </div>

              <button type="submit" class="btn btn-primary btn-block mb-4">
                Sign In
              </button>

            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
<!-- Section: Design Block -->
<!-- Section: Design Block -->

    <%-- <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-lg-block bg-login-image"></div>
	                            <div class="col-lg-6">
	                                <div class="p-5">
	                                    <div class="text-center">
	                                        <h1 class="h4 text-gray-900 mb-4">Login</h1>
	                                    </div>
	                                    <form class="user" id="loginValidate" name='f' method='POST' action="login">
	                                    
	                                        	<div class="form-group">
	                                            <input type="text" class="form-control"
	                                                id="username" name="username" autocomplete="off" required  aria-describedby="emailHelp"
	                                                placeholder="Enter User Name">
	                                        </div>
	                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	                                        <div class="form-group">
	                                            <input type="password" class="form-control"
	                                                 name="password" id="password" autocomplete="off" required  placeholder="Password">
	                                        </div>
	                                        <div class="">
	                                            <button type="submit" id="kt_login_singin_form_submit_button" class="btn btn-primary btn-user btn-block">Login</button>
	                                        </div>
	                                        
	                                    </form>
	                                </div>
	                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div> --%>
        <!--end::Main-->
<!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath}/app-assets/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/app-assets/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath}/app-assets/js/sb-admin-2.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/login.js"></script>
    </body>
    <!--end::Body-->

    </html>