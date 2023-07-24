$('document').ready(function() {

	getPendingInvoiceList('','');

	$(document).on('shown.bs.modal', '#invoiceDetailsModal', function() {
		//      $('#invoiceDataTable').DataTable().ajax.reload();
		$(this).trigger('resize')
	});
	$('#select-all').on('click', function(){
      // Check/uncheck all checkboxes in the table
      var rows = table.rows({ 'search': 'applied' }).nodes();
      $('input[type="checkbox"]', rows).prop('checked', this.checked);
   });
   
//	var table = $('#invoiceDataTable').DataTable();
//	table.on('click', 'tbody tr', function() {
//		var data = table.row(this).data();
//		$('#pendingInvoiceDiv').hide();
//		$('#pendingInvoiceLineDiv').show();
//		getPendingInvoiceDetails(data.salesInvoiceId,data.salesInvoiceNo);
//	});


$('#invoiceDataTable tbody').on('change', 'input[type="checkbox"]', function(){
      // If checkbox is not checked
      if(!this.checked){
         var el = $('#select-all').get(0);
         // If "Select all" control is checked and has 'indeterminate' property
         if(el && el.checked && ('indeterminate' in el)){
            // Set visual state of "Select all" control 
            // as 'indeterminate'
            el.indeterminate = true;
         }
      }
   });
    
	
	$('#fromDate').daterangepicker({ locale: {
          format: 'DD/MM/YYYY'
     }});

	 $('#fromDate').on('apply.daterangepicker', function(ev, picker) {
	      getPendingInvoiceList(picker.startDate.format('DD/MM/YYYY'),picker.endDate.format('DD/MM/YYYY'));
	  });
});

function closeInvoiceDetailsDiv(){
	$('#pendingInvoiceDiv').show();
	$('#pendingInvoiceLineDiv').hide();
}
function getPendingInvoiceList(startDate,endDate) {
	$('#invoiceDataTable').DataTable({
		ordering: false,
		destroy: true,
		searching: true,
		scrollY: true,
		scrollX: true,
		scrollCollapse: true,
		processing: true,
		serverSide: true,
		deferRender: true,
		responsive: true,
		async: true,
		ajax: {
			url: 'getPendingInvoiceList',
			data:{
				"startDate":startDate,
				"endDate":endDate
			}
		},
	
		columns: [
			{ data: '' },
			{ data: 'salesInvoiceNo' },
			{ data: 'salesInvoiceType' },
			{ data: 'salesInvoiceDate' },
			{ data: 'custFName' },
			{ data: 'custGSTNo' },
			{ data: 'total' },
		], 
		columnDefs: [
			{
				'targets': 0,
				'searchable': false,
				'orderable': false,
				'className': 'dt-body-center',
				'render': function(data, type, full, meta) {
					return '<input type="checkbox" name="id[]" value="'
						+ $('<div/>').text(data).html() + '">';
				}
			}],
		select: {
        style: 'multi',
    },
    order: [[1, 'asc']]
	});
}


function jsonPrepareFormatter(cellvalue, options, rowObject) {
	return "<a onclick='downloadJsonByInvoice(\"" + rowObject.salesInvoiceId + "\",\"" + rowObject.salesInvoiceNo + "\");' title='JSON Prepare' href='javascript:void(0)' class='btn btn-sm btn-light-info btn-hover-light-info btn-icon mr-2 my-1 my-lg-0' > <i class='fa fa-download'></i></a>";
}

function downloadJsonByInvoice(salesInvoiceId, salesInvoiceNo) {
	var link = document.createElement('a');
	
	document.body.appendChild(link);
	link.click();
}


function getPendingInvoiceDetails(salesInvoiceId,salesInvoiceNo) {
	var hrefLink = "getPrepareJsonFileInvoice?salesInvoiceId=" + salesInvoiceId + "&salesInvoiceNo=" + salesInvoiceNo;
	$("#downloadJSON").attr("href",hrefLink);
	
	$('#invoiceDetailDataTable').DataTable({
		ordering: false,
		destroy: true,
		searching: false,
		scrollY: true,
		scrollX: true,
		scrollCollapse: true,
		processing: true,
		serverSide: true,
		deferRender: true,
		responsive: true,
		async: true,
		lengthMenu: [5, 10, 25, 50],
		ajax: {
			url: 'getPendingInvoiceItemList/'+salesInvoiceId,
		},
		columns: [
			{ title: 'Product Description', data: 'PrdDesc' },
			{ title: 'Is Service', data: 'IsServc',render:formattorIsService },
			{ title: 'HSN Code', data: 'HsnCd' },
			{ title: 'Barcode', data: 'Barcde' },
			{ title: 'Quantity', data: 'Qty' },
			{ title: 'Free Quantity', data: 'FreeQty' },
			{ title: 'Unit', data: 'Unit' },
			{ title: 'Unit Price', data: 'UnitPrice' },
			{ title: 'Total Amount', data: 'TotAmt' },
			{ title: 'Discount', data: 'Discount' },
			{ title: 'Assessable Amount', data: 'AssAmt' },
			{ title: 'GST Rate', data: 'GstRt' },
			{ title: 'Igst Amount', data: 'IgstAmt' },
			{ title: 'Cgst Amount', data: 'CgstAmt' },
			{ title: 'Sgst Amount', data: 'SgstAmt' },
			{ title: 'Total Item Value', data: 'TotItemVal' },
		],
	});
}

function formattorIsService(cellvalue, options, rowObject){
	if(rowObject.IsServc === "1"){
		return "Y";
	}else{
		return "N";
	}
}

