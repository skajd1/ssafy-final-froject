<script setup>
import flistitem from "@/components/Main/FListItem.vue";
import { ref } from "vue";
import { getLikeCount } from "@/api/AttractionLikeApi";

import { getTripInfoById } from "@/api/TripApi";
import { Navigation, Pagination, Scrollbar, A11y } from "swiper/modules";
import { Swiper, SwiperSlide } from "swiper/vue";
import "swiper/css";
import "swiper/css/navigation";
import "swiper/css/pagination";
import "swiper/css/scrollbar";

const modules = [Navigation, Pagination, Scrollbar, A11y];

const top5 = ref([]);

const likecount = ref({});
getLikeCount(
  (res) => {
    // content_id를 key, value는 like count인 객체
    likecount.value = res.data;

    // key 기준 내림차순으로 정렬 후 상위 5개 content_id,count 추출
    const sorted = Object.entries(likecount.value).sort((a, b) => b[1] - a[1]);

    top5.value = sorted.slice(0, 5);
    // console.log(top5);
    top5.value.forEach((i) => {
      getTripInfoById(
        i[0],
        (res) => {
          i.push(res.data[0].firstImage);
        },
        (err) => {
          console.log(err);
        }
      );
    });
    // console.log(items.value);
  },
  (err) => {
    console.log(err);
  }
);
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
      <swiper-slide v-for="(i, index) in top5">
        <flistitem :item="i" />
      </swiper-slide>
    </swiper>
  </div>
</template>

<style scoped>
.container {
  width: 80%;
  background-color: var(--vt-c-bg);
  color: var(--main-color);
  margin: 0 auto;
  margin-bottom: 1rem;
  padding-bottom: 3rem;
  border-radius: 10px;
}
</style>
