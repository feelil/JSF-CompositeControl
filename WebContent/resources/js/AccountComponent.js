function matchStart (state,term) 
		  {		     
			  if (state.accountNumber.toUpperCase().indexOf(term.toUpperCase()) == 0) {
			    return true;
			    }			
			  return false;
		}
	  function template(state, container) 
		{		 if (state.loading) return result.text;
		
			var htt='<div>' 
			     +'<div style=" float: left;padding: 5px;padding-left: 20px;"> Hesap No:'+ state.accountNumber +'</div>'			
				+'<div style="float: right;padding: 5px;padding-right: 20px;">Hesap Adı: ' + state.accountName + '</div>'
				+'<div style=" clear: both;"></div>'
			 	+'<div style="float: left; padding: 5px;padding-left: 20px;:">Hesap Bakiyesi: 5.603.617,91 TL </div>'
				+'<div style="float: right;padding: 5px;padding-right: 20px;"><b> Kullanılabilir Bakiye: 5.603.617,91 TL  </b></div>'
				+'</div>';
  				return $(htt);
				}
		 function formatState (state) 
	     {
	    
			  if (!state.accountId) { return state.ibanNumber; }
			
			  var $state = $(
			     '<div style="margin:15px;padding:0px">'
			    +'<div> Hesap Adı : '+  state.accountName +'</div>'
			    +'<div> IBAN ' + state.ibanNumber + '</div>'
				+'<div>Şube: '+ state.accountName +'</div>'
				+'<div>Hesap Bakiyesi: 5.603.617,91 TL </div>'
				+'<div><b> Kullanılabilir Bakiye: 5.603.617,91 TL  </b></div>'
				+'</div>'
			  );
			  return $state;
	     };