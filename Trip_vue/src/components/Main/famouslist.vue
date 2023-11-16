<script setup>
import flistitem from "@/components/Main/FListItem.vue";
import { Navigation, Pagination, Scrollbar, A11y } from "swiper/modules";
import { Swiper, SwiperSlide } from "swiper/vue";
import "swiper/css";
import "swiper/css/navigation";
import "swiper/css/pagination";
import "swiper/css/scrollbar";
const onSwiper = (swiper) => {
  console.log(swiper);
};
const onSlideChange = () => {
  console.log("slide change");
};
const modules = [Navigation, Pagination, Scrollbar, A11y];

const item = 5;
const img = "https://picsum.photos/800/400?random=";
</script>

<template>
  <div class="container">
    <h2>인기여행지</h2>
    <swiper
      :modules="modules"
      :slides-per-view="1"
      :space-between="50"
      navigation
      :pagination="{ clickable: true }"
      :scrollbar="{ draggable: true }"
      @swiper="onSwiper"
      @slideChange="onSlideChange"
    >
      <swiper-slide v-for="i in item" :key="i">
        <flistitem :img="img + i" />
      </swiper-slide>
    </swiper>
  </div>
</template>

<style scoped>
.container {
  width: 80%;
  background-color: #f2f2f2;

  margin: 0 auto;
  margin-bottom: 1rem;
  padding-bottom: 2rem;
}
</style>
