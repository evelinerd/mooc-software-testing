package tudelft.discount;

public class DiscountApplier {

    private ProductDao dao;

    public DiscountApplier (ProductDao dao) {
        this.dao = dao;
    }

    public void setNewPrices() {

        for (Product product : dao.all()) {
            double originalPrice = product.getPrice();
            if (originalPrice < 0) {
                product.setPrice(0); // If the price is negative I set the price to 0. I know this isn't ideal exception handling but that is past my learning goals for this subject.
            } else {
                if (product.getCategory().equals("BUSINESS")) {
                    double discountedPrice = Math.round(product.getPrice() * 0.9 * 100.0) / 100.0;
                    product.setPrice(discountedPrice);
                }
                if (product.getCategory().equals("HOME")) {
                    double markedUpPrice = Math.round(product.getPrice() * 1.1 * 100.0) / 100.0;
                    product.setPrice(markedUpPrice);
                }
            }
        }
    }
}
