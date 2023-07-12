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
      
    </head>
    <!--end::Head-->

    <!--begin::Body-->

   <body class="bg-gradient-primary">

    <div class="container">

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
                                    <div id="displayError">
								<c:if test="${not empty error}">
								<c:choose>  
									<c:when test="${ error == 'Maximum sessions of 1 for this principal exceeded'}">
										<span style="color: red">Only one user can login at a time.</span>
									</c:when>
									<c:when test="${ error == 'External system authentication failed'}">
										<span style="color: red">Invalid user name or password.</span>
									</c:when>
									<c:otherwise>
									<span style="color: red">${error}</span>
									</c:otherwise>
									</c:choose>
								</c:if>
							</div>
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

    </div>
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