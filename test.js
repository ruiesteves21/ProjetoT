import http from "k6/http";
import { sleep } from "k6";

export default function () {
  const urls = [
    "https://petstore.octoperf.com/actions/Catalog.action",
    "https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH",
    "https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-01",
    "https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-1",
    "https://petstore.octoperf.com/actions/Cart.action?viewCart=",
    "https://petstore.octoperf.com/actions/Order.action?newOrderForm=",
    "https://petstore.octoperf.com/actions/Order.action?newOrder=&confirmed=true"
  ];

  urls.forEach(url => {
    http.get(url);
    sleep(1);
  });
}
