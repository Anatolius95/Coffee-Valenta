    package cz.uhk.coffee_valenta;

    import android.os.Bundle;
    import android.support.v7.app.ActionBarActivity;
    import android.view.View;
    import android.widget.TextView;

    import java.text.NumberFormat;

    public class CoffeeOrder extends ActionBarActivity {

        int NumberOfCoffees=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_order);
    }
        public void submitOrder(View view) {
            TextView priceTextView = (TextView) findViewById(
                    R.id.price_text_view);
            priceTextView.setText("Order received");
        }
    public void submitOrderPlus(View view) {
        NumberOfCoffees = NumberOfCoffees + 1;
        display(NumberOfCoffees);
        displayPrice(NumberOfCoffees * 12);
    }
        public void submitOrderMinus(View view) {
            if (NumberOfCoffees < 1) {
                NumberOfCoffees = NumberOfCoffees + 1;
            }

            NumberOfCoffees = NumberOfCoffees - 1;
            display(NumberOfCoffees);
            displayPrice(NumberOfCoffees * 12);
        }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

        private void displayPrice(int number) {
            TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
            priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
        }
}