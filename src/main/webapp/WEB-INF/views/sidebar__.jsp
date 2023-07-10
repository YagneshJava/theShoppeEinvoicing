<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  


   <!--begin::Aside-->
				<div class="aside aside-left aside-fixed d-flex flex-column flex-row-auto bg-color" id="kt_aside">
					<!--begin::Brand-->
					<div class="brand flex-column-auto" id="kt_brand" style="padding-left: 10px; margin-top: 25px; padding-right: 65px;">
					
						<!--begin::Logo-->
						<a href="" class="brand-logo">
							<img alt="Logo" src="assets/media/logos/logo-1.svg" class="logo">
							
							<!--<img class="img-fluid" alt="Logo" src="assets/media/logos/logo-dark.png" />-->
							<!--<h3 style="color: #fff;padding-top: 11px;height: 15px;">PHARMA ETENDER</h3>-->
						</a>
						<!--end::Logo-->

						<!--begin::Toggle-->
						
						
						<div class="brand-toggle" id="kt_aside_toggle">
							<button class="burger-icon burger-expand" style="position: relative; overflow: visible; left: 12px;"><span class=" svg-icon svg-icon svg-icon-xl"></span></button>
							<button class="icons8-close close-hidden btn" style="position: absolute; top: 42px; right: 22px"><span class=" svg-icon svg-icon svg-icon-xl"></span></button>
						</div>
						
					
						<!--end::Toolbar-->
					</div>
					<!--end::Brand-->
					
					<!--begin::Aside Menu-->
					<div class="aside-menu-wrapper flex-column-fluid" id="kt_aside_menu_wrapper">
						
						<!--begin::Menu Container-->
						<div id="kt_aside_menu" class="aside-menu my-4" data-menu-vertical="1" data-menu-scroll="1" data-menu-dropdown-timeout="500">
							<!--begin::Menu Nav-->
							<ul class="menu-nav">
								<security:authorize access="hasRole('ROLE_ADMIN')">
									<li id="adminDashboardLI" class="menu-item" aria-haspopup="true">
										<a href="" class="menu-link">
											<i class="icon-xxl la la-layer-group mr-4"></i>
											<span class="menu-text">Dashboard</span>
										</a>
									</li>


									<li id="customerVerificationLI" class="menu-item" aria-haspopup="true">
										<a href="customerVerificationPage" class="menu-link ">
											<i class="icon-xxl la la-user-check mr-4"></i>
											<span class="menu-text"> Customer Verification  </span>
										</a>
									</li>

									<li id="productMappingLI" class="menu-item" aria-haspopup="true">
										<a href="productMapping" class="menu-link">
											<i class="icon-xxl la fab la-dropbox mr-4"></i>
											<span class="menu-text"> Product Mapping </span>
										</a>
									</li>
	
	
									<li id="purchaseOrderViewLI" class="menu-item" aria-haspopup="true">
										<a href="purchaseOrderView" class="menu-link">
											<i class="icon-xxl mr-4 la la-clipboard-check"></i>
											<span class="menu-text"> Purchase Order View  </span>
										</a>
									</li>
	
	
									<li id="quotationViewLI" class="menu-item" aria-haspopup="true">
										<a href="quotationView" class="menu-link">
											<i class="icon-xxl mr-4 la la-clipboard-list"></i>
											<span class="menu-text"> Quotation View  </span>
										</a>
									</li>
								</security:authorize>
								
								
								<security:authorize access="hasRole('ROLE_CUSTOMER')">
									<li id="customerDashboardLI" class="menu-item" aria-haspopup="true">
										<a href="wellcomeCustomerPage" class="menu-link">
										<i class="icon-xxl  mr-4  la la-dashboard"></i>	
											<span class="menu-text"> Dashboard</span>
										</a>
									</li>


									<li  id="customerTenderPageLI" class="menu-item" aria-haspopup="true">
										<a href="customerTenderPage" class="menu-link">
											<i class="icon-xxl mr-4 la la-clipboard-list"></i>
											<span class="menu-text">  Quotation  </span>
										</a>
									</li>

									<li id="orderConfirmationLI"  class="menu-item" aria-haspopup="true">
										<a href="orderConfirmation" class="menu-link">
											<i class="icon-xxl la fab la-dropbox mr-4"></i>
											<span class="menu-text"> Orders  </span>
										</a>
									</li>
	
	
									<li id="orderHistoryLI" class="menu-item" aria-haspopup="true">
										<a href="orderHistory" class="menu-link">
											<i class="icon-xxl mr-4 la la-history"></i>
											<span class="menu-text"> Order History  </span>
										</a>
									</li>
	
									<li id="offersPageLI" class="menu-item" aria-haspopup="true">
										<a href="offersPage" class="menu-link">
										<i class="icon-xxl  mr-4  flaticon2-percentage"></i>
											<span class="menu-text"> Offers  </span>
										</a>
									</li>
									<li id="pricePageLI" class="menu-item" aria-haspopup="true">
										<a href="marketPricePage" class="menu-link">
										<i class="icon-xxl  mr-4 la la-pound-sign"></i>
											<span class="menu-text"> Market Price  </span>
										</a>
									</li>
								</security:authorize>
								
								<security:authorize access="hasRole('ROLE_SUPPLIER')">
									<li id="supplierDashboardLI" class="menu-item" aria-haspopup="true">
										<a href="wellcomeSupplierPage" class="menu-link">
											<i class="icon-xl fas fa-home mr-4"></i>
											<span class="menu-text">Dashboard</span>
										</a>
									</li>
									
									
									
								<!--start:: menu-item-submenu -->
								<li class="menu-item menu-item-submenu" aria-haspopup="true" data-menu-toggle="hover">
									<a href="javascript:;" class="menu-link menu-toggle">
										<i class="icon-xl mr-4 fas fa-layer-group"></i>
										<span class="menu-text"> TITLE  </span>
										<i class="menu-arrow"></i>
									</a>
									<div class="menu-submenu">
										<i class="menu-arrow"></i>
										<ul class="menu-subnav">
											<li class="menu-item menu-item-parent" aria-haspopup="true">
												<span class="menu-link">
													<span class="menu-text">Applications</span>
												</span>
											</li>	
											
										   <li id="supplierTenderPageLI" class="menu-item" aria-haspopup="true">
												<a href="supplierQuotationPage" class="menu-link">
													<i class="menu-bullet menu-bullet-line">
														<span></span>
													</i>
													<span class="menu-text">  Quotation  </span>
												</a>
											</li>										
											
												
										<li id="supplierOrderConfirmationLI"  class="menu-item" aria-haspopup="true">
											<a href="supplierOrderConfirmation" class="menu-link">
												<i class="menu-bullet menu-bullet-line">
														<span></span>
													</i>
												<span class="menu-text"> Order  </span>
											</a>
										</li>
											
										</ul>
									</div>
								</li>
								<!--end:: menu-item-submenu -->
								
								
								<!--start:: menu-item-submenu -->
								<li class="menu-item menu-item-submenu" aria-haspopup="true" data-menu-toggle="hover">
									<a href="javascript:;" class="menu-link menu-toggle">
										<i class="icon-xl fas fa-layer-group mr-4"></i>
										<span class="menu-text"> TITLE 2  </span>
										<i class="menu-arrow"></i>
									</a>
									<div class="menu-submenu">
										<i class="menu-arrow"></i>
										<ul class="menu-subnav">
											
									<li id="supplierQuotGeneratePageLI" class="menu-item" aria-haspopup="true">
										<a href="supplierQuotGeneratePage" class="menu-link">
											<i class="menu-bullet menu-bullet-line">
														<span></span>
											</i>
											<span class="menu-text">  Create Quotation  </span>
										</a>
									</li>					
									
								   <li id="supplierPendingOrderLI"  class="menu-item" aria-haspopup="true">
										<a href="supplierPendingOrder" class="menu-link">
											<i class="menu-bullet menu-bullet-line">
														<span></span>
													</i>
											<span class="menu-text"> Order  </span>
										</a>
									</li>	
									
									<li id="supplierOrderHistoryLI" class="menu-item" aria-haspopup="true">
										<a href="supplierOrderHistory" class="menu-link">
											<i class="menu-bullet menu-bullet-line">
											<span></span>
											</i>
											<span class="menu-text"> Order History  </span>
										</a>
									</li>			
											
									</ul>
									</div>
								</li>
								<!--end:: menu-item-submenu -->

									

	
									<li id="supplierPriceListPageLI" class="menu-item" aria-haspopup="true">
										<a href="supplierPriceListPage" class="menu-link">
										<i class="icon-xl mr-4  fas fa-list"></i>
											<span class="menu-text"> Price List  </span>
										</a>
									</li>
	
								</security:authorize>
								
								
								<security:authorize access="hasRole('ROLE_MANUFACTURER')">
									<li id="manufacturerDashboardLI" class="menu-item" aria-haspopup="true">
										<a href="manufacturerWelcomePage" class="menu-link">
											<i class="icon-xxl la la-layer-group mr-4"></i>
											<span class="menu-text">Dashboard</span>
										</a>
									</li>


									<li id="manufacturerTenderPageLI" class="menu-item" aria-haspopup="true">
										<a href="manufacturerQuotationPage" class="menu-link">
											<i class="icon-xxl mr-4 la la-clipboard-list"></i>
											<span class="menu-text">  Quotation  </span>
										</a>
									</li>

									<li id="manufacturerOrderConfirmationLI"  class="menu-item" aria-haspopup="true">
										<a href="manufacturerReceivedOrders" class="menu-link">
											<i class="icon-xxl la fab la-dropbox mr-4"></i>
											<span class="menu-text"> Order  </span>
										</a>
									</li>
										
									<li id="manufacturerPriceListPageLI" class="menu-item" aria-haspopup="true">
										<a href="manufacturerPriceListPage" class="menu-link">
										<i class="icon-xxl mr-4  flaticon-list-1"></i>
											<span class="menu-text"> Price List  </span>
										</a>
									</li>
	
								</security:authorize>
								
								
							</ul>
							<!--end::Menu Nav-->
							<ul class="menu-nav">
								<security:authorize access="hasAnyRole('ROLE_CUSTOMER','ROLE_SUPPLIER','ROLE_PENDING')">
									<li id="profileCompanyDetailsPageLI"  class="menu-item" aria-haspopup="true">
										<a href="profileCompanyDetailsPage" class="menu-link">
											<i class="icon-xl mr-4 fas fa-user"></i>
											<span class="menu-text"> Profile  </span>
										</a>
									</li>
								</security:authorize>
	
					
									<li class="menu-item" aria-haspopup="true">
										<a href="#" id="kt_quick_notifications_toggle" data-toggle="tooltip" data-placement="right" data-container="body" data-boundary="window" title="" class="menu-link">
											<!-- <i class="icon-xxl mr-4 fas fa-bell"></i> -->
											<i class="icon-xl mr-4 fas fa-bell"></i>
											<span class="menu-text"> Notifications  </span>
											<span class="label label-sm label-light-success  label-rounded font-weight-bolder position-absolute top-0  mt-2 ml-6">10</span>
										</a>
									</li>								

						
									<li class="menu-item  text-danger" aria-haspopup="true" data-menu-toggle="hover">
										<a href="logout" class="menu-link menu-toggle">
											<i class="icon-xl mr-4 text-danger la la-power-off"></i>
											<span class="menu-text text-danger "> Sign Out </span>
										</a>
									</li>
							</ul>
							
							
						<!--	<div class="sidebar-widgets">
								<img src="/TenderMangement/assets/media/svg/illustrations/product-iteration.svg" class="sideimg" alt="" style="margin-top: 270px; width: 95%;">
						
						  	</div>	  -->
						  	
						  	
						</div>
						<!--end::Menu Container-->
					</div>
					<!--end::Aside Menu-->
				</div>
				<!--end::Aside-->
				
				 <!-- Start Pre-loader -->
				  <div id="preLoader" class="pre-loader-wrap" style="display: none !important;">
				    <div class="pre-loader triangle">
				      <svg viewBox="0 0 86 80">
				        <polygon points="43 8 79 72 7 72"></polygon>
				      </svg>
				      <!-- <span>Loading...</span> -->
				    </div>
				  </div>
				  <!-- End Pre-loader -->
				
				
				
				
				
						<!-- begin::Notifications Panel-->
		<div id="kt_quick_notifications" class="offcanvas offcanvas-left p-10">
			<!--begin::Header-->
			<div class="offcanvas-header d-flex align-items-center justify-content-between mb-10">
				<h3 class="font-weight-bold m-0">Notifications
				<small class="text-muted font-size-sm ml-2">24 New</small></h3>
				<a href="#" class="btn btn-xs btn-icon btn-light btn-hover-primary" id="kt_quick_notifications_close">
					<i class="ki ki-close icon-xs text-muted"></i>
				</a>
			</div>
			<!--end::Header-->
			<!--begin::Content-->
			<div class="offcanvas-content pr-5 mr-n5">
				<!--begin::Nav-->
				<div class="navi navi-icon-circle navi-spacer-x-0">
					<!--begin::Item-->
					<a href="#" class="navi-item">
						<div class="navi-link rounded">
							<div class="symbol symbol-50 symbol-circle mr-3">
								<div class="symbol-label">
									<i class="flaticon-bell text-success icon-lg"></i>
								</div>
							</div>
							<div class="navi-text">
								<div class="font-weight-bold font-size-lg">5 new user generated report</div>
								<div class="text-muted">Reports based on sales</div>
							</div>
						</div>
					</a>
					<!--end::Item-->
					<!--begin::Item-->
					<a href="#" class="navi-item">
						<div class="navi-link rounded">
							<div class="symbol symbol-50 symbol-circle mr-3">
								<div class="symbol-label">
									<i class="flaticon2-box text-danger icon-lg"></i>
								</div>
							</div>
							<div class="navi-text">
								<div class="font-weight-bold font-size-lg">2 new items submited</div>
								<div class="text-muted">by Grog John</div>
							</div>
						</div>
					</a>
					<!--end::Item-->
					<!--begin::Item-->
					<a href="#" class="navi-item">
						<div class="navi-link rounded">
							<div class="symbol symbol-50 symbol-circle mr-3">
								<div class="symbol-label">
									<i class="flaticon-psd text-primary icon-lg"></i>
								</div>
							</div>
							<div class="navi-text">
								<div class="font-weight-bold font-size-lg">79 PSD files generated</div>
								<div class="text-muted">Reports based on sales</div>
							</div>
						</div>
					</a>
					<!--end::Item-->
					<!--begin::Item-->
					<a href="#" class="navi-item">
						<div class="navi-link rounded">
							<div class="symbol symbol-50 symbol-circle mr-3">
								<div class="symbol-label">
									<i class="flaticon2-supermarket text-warning icon-lg"></i>
								</div>
							</div>
							<div class="navi-text">
								<div class="font-weight-bold font-size-lg">$2900 worth producucts sold</div>
								<div class="text-muted">Total 234 items</div>
							</div>
						</div>
					</a>
					<!--end::Item-->
					<!--begin::Item-->
					<a href="#" class="navi-item">
						<div class="navi-link rounded">
							<div class="symbol symbol-50 symbol-circle mr-3">
								<div class="symbol-label">
									<i class="flaticon-paper-plane-1 text-success icon-lg"></i>
								</div>
							</div>
							<div class="navi-text">
								<div class="font-weight-bold font-size-lg">4.5h-avarage response time</div>
								<div class="text-muted">Fostest is Barry</div>
							</div>
						</div>
					</a>
					<!--end::Item-->
					<!--begin::Item-->
					<a href="#" class="navi-item">
						<div class="navi-link rounded">
							<div class="symbol symbol-50 symbol-circle mr-3">
								<div class="symbol-label">
									<i class="flaticon-safe-shield-protection text-danger icon-lg"></i>
								</div>
							</div>
							<div class="navi-text">
								<div class="font-weight-bold font-size-lg">3 Defence alerts</div>
								<div class="text-muted">40% less alerts thar last week</div>
							</div>
						</div>
					</a>
					<!--end::Item-->
					<!--begin::Item-->
					<a href="#" class="navi-item">
						<div class="navi-link rounded">
							<div class="symbol symbol-50 symbol-circle mr-3">
								<div class="symbol-label">
									<i class="flaticon-notepad text-primary icon-lg"></i>
								</div>
							</div>
							<div class="navi-text">
								<div class="font-weight-bold font-size-lg">Avarage 4 blog posts per author</div>
								<div class="text-muted">Most posted 12 time</div>
							</div>
						</div>
					</a>
					<!--end::Item-->
					<!--begin::Item-->
					<a href="#" class="navi-item">
						<div class="navi-link rounded">
							<div class="symbol symbol-50 symbol-circle mr-3">
								<div class="symbol-label">
									<i class="flaticon-users-1 text-warning icon-lg"></i>
								</div>
							</div>
							<div class="navi-text">
								<div class="font-weight-bold font-size-lg">16 authors joined last week</div>
								<div class="text-muted">9 photodrapehrs, 7 designer</div>
							</div>
						</div>
					</a>
					<!--end::Item-->
					<!--begin::Item-->
					<a href="#" class="navi-item">
						<div class="navi-link rounded">
							<div class="symbol symbol-50 symbol-circle mr-3">
								<div class="symbol-label">
									<i class="flaticon2-box text-info icon-lg"></i>
								</div>
							</div>
							<div class="navi-text">
								<div class="font-weight-bold font-size-lg">2 new items have been submited</div>
								<div class="text-muted">by Grog John</div>
							</div>
						</div>
					</a>
					<!--end::Item-->
					<!--begin::Item-->
					<a href="#" class="navi-item">
						<div class="navi-link rounded">
							<div class="symbol symbol-50 symbol-circle mr-3">
								<div class="symbol-label">
									<i class="flaticon2-download text-success icon-lg"></i>
								</div>
							</div>
							<div class="navi-text">
								<div class="font-weight-bold font-size-lg">2.8 GB-total downloads size</div>
								<div class="text-muted">Mostly PSD end AL concepts</div>
							</div>
						</div>
					</a>
					<!--end::Item-->
					<!--begin::Item-->
					<a href="#" class="navi-item">
						<div class="navi-link rounded">
							<div class="symbol symbol-50 symbol-circle mr-3">
								<div class="symbol-label">
									<i class="flaticon2-supermarket text-danger icon-lg"></i>
								</div>
							</div>
							<div class="navi-text">
								<div class="font-weight-bold font-size-lg">$2900 worth producucts sold</div>
								<div class="text-muted">Total 234 items</div>
							</div>
						</div>
					</a>
					<!--end::Item-->
					<!--begin::Item-->
					<a href="#" class="navi-item">
						<div class="navi-link rounded">
							<div class="symbol symbol-50 symbol-circle mr-3">
								<div class="symbol-label">
									<i class="flaticon-bell text-primary icon-lg"></i>
								</div>
							</div>
							<div class="navi-text">
								<div class="font-weight-bold font-size-lg">7 new user generated report</div>
								<div class="text-muted">Reports based on sales</div>
							</div>
						</div>
					</a>
					<!--end::Item-->
					<!--begin::Item-->
					<a href="#" class="navi-item">
						<div class="navi-link rounded">
							<div class="symbol symbol-50 symbol-circle mr-3">
								<div class="symbol-label">
									<i class="flaticon-paper-plane-1 text-success icon-lg"></i>
								</div>
							</div>
							<div class="navi-text">
								<div class="font-weight-bold font-size-lg">4.5h-avarage response time</div>
								<div class="text-muted">Fostest is Barry</div>
							</div>
						</div>
					</a>
					<!--end::Item-->
				</div>
				<!--end::Nav-->
			</div>
			<!--end::Content-->
		</div>
		<!-- end::Notifications Panel-->


		<script type="text/javascript">
			$('.burger-expand').click(function(){
				$('.icons8-close').show();
				$('.burger-icon').hide(); 	
			});
			$('.close-hidden').click(function(){
				$('.burger-icon').show();
				$('.icons8-close').hide();
			});
		</script>

		
    