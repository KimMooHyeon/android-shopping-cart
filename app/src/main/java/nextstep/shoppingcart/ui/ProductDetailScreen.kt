package nextstep.shoppingcart.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.detail.ProductDetailUiState
import nextstep.shoppingcart.ui.component.ProductDetailContent
import nextstep.shoppingcart.ui.component.ProductListTopBar
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductDetailScreen(
    uiState: ProductDetailUiState,
    navigateToCart: (String) -> Unit,
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text("ProductDetailScreen")
    when (uiState) {
        ProductDetailUiState.Empty -> {
            //TODO Empty View
        }

        ProductDetailUiState.Error -> {
            //TODO Error View
        }

        ProductDetailUiState.Loading -> {
            //TODO Loading View
        }

        is ProductDetailUiState.ProductDetail -> {
            Scaffold(
                modifier = modifier
                    .fillMaxSize(),
                topBar = {
                    ProductListTopBar(
                        topBarTitle = "상품 상세",
                        leftIcon = Icons.AutoMirrored.Filled.ArrowBack,
                        onLeftIconClicked = { onBackButtonClick() })
                },
                bottomBar = {
                    Button(
                        shape = MaterialTheme.shapes.large,
                        onClick = { navigateToCart(uiState.product.productId) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .navigationBarsPadding()
                            .height(54.dp),
                    ) {
                        Text("장바구니 담기", fontSize = 20.sp)
                    }
                }
            ) { contentPadding ->
                ProductDetailContent(
                    modifier = Modifier
                        .padding(contentPadding),
                    product = uiState.product,
                    navigateToCart = { id -> navigateToCart(id) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    ShoppingCartTheme {
        ProductDetailScreen(ProductDetailUiState.ProductDetail(
            product = Product(
                name = "PET 보틀 - 음료수,정사각형 음료수,정사각형 음료수,정사각형 음료수",
                imageUrl = "https://i.namu.wiki/i/rwoGbf-OhaV1A1I77FtQEWojKsa-i9J0HZ0E3tFfr4gdi7fCHRh7DwaqLkLzKdruftxpu_twLfkhwgMxc3QrvgY9HhwbwB7W_YPGbkjpCIxFO9abcyQSLgM8NVUkKJ6WPegKkT35ukb0NXXRHeMW1zGcxZz_9zx63o9Pnat6I3Q.webp",
                price = "10000",
                productId = "id1"
            )
        ), {}, {})
    }
}
